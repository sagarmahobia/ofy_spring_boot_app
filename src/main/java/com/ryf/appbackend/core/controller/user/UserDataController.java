package com.ryf.appbackend.core.controller.user;


import com.ryf.appbackend.core.services.OpportunityUtil;
import com.ryf.appbackend.core.services.S3AmazonService;
import com.ryf.appbackend.jpa.dao.*;
import com.ryf.appbackend.jpa.entities.Image;
import com.ryf.appbackend.jpa.entities.OpportunityEntity;
import com.ryf.appbackend.jpa.entities.enums.FundingType;
import com.ryf.appbackend.jpa.entities.enums.OpportunityType;
import com.ryf.appbackend.jpa.entities.enums.Region;
import com.ryf.appbackend.jpa.entities.user.Bookmark;
import com.ryf.appbackend.jpa.entities.user.SubmittedOpportunityEntity;
import com.ryf.appbackend.jpa.entities.user.User;
import com.ryf.appbackend.jwtsecurity.model.JwtUserDetails;
import com.ryf.appbackend.models.dto.Opportunity;
import com.ryf.appbackend.models.dto.Status;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserDataController {

    @Autowired
    BookmarkDao bookmarkDao;
    @Autowired
    UserDao userDao;

    @Autowired
    OpportunityDao opportunityDao;

    @Autowired
    SubmittedOpportunityDao submittedOpportunityDao;

    @Autowired
    S3AmazonService s3AmazonService;

    @Autowired
    ImageDao imageDao;

    @Autowired
    OpportunityUtil opportunityUtil;

    @GetMapping(path = "/api/v1/protected/user/bookmarks")
    public List<Opportunity> getAllBookMarks(Authentication authentication,
                                             @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                             @RequestParam(value = "size", required = false, defaultValue = "10") int size) {

        JwtUserDetails details = (JwtUserDetails) authentication.getPrincipal();
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id"));

        return bookmarkDao
                .findAllByUserId(details.getId(), pageRequest)
                .stream()
                .map(Bookmark::getOpportunity)
                .map(new OpportunityUtil()::getOpportunityFromEntity)
                .collect(Collectors.toList());

    }


    @GetMapping(path = "/api/v1/protected/user/is_bookmarked")
    public Status isBookmarked(Authentication authentication,
                               @RequestParam("opportunity_id") long id) {

        JwtUserDetails details = (JwtUserDetails) authentication.getPrincipal();

        Boolean aBoolean = bookmarkDao.existsBookmarkByUserIdAndOpportunityId(details.getId(), id);

        return Status.builder().currentState(aBoolean).build();
    }


    @GetMapping(path = "/api/v1/protected/user/toggle_bookmarked")
    public Status toggleBookMark(Authentication authentication,
                                 @RequestParam("opportunity_id") long opportunityId) {

        JwtUserDetails details = (JwtUserDetails) authentication.getPrincipal();

        User one = userDao.getOne(details.getId());
        Boolean aBoolean = bookmarkDao.existsBookmarkByUserIdAndOpportunityId(details.getId(), opportunityId);

        if (aBoolean) {

            Bookmark bookmarkByUserIdAndOpportunityId = bookmarkDao.findBookmarkByUserIdAndOpportunityId(details.getId(), opportunityId);
            one.getBookmarks().remove(bookmarkByUserIdAndOpportunityId);


        } else {

            Bookmark bookmark = new Bookmark();
            bookmark.setOpportunity(opportunityDao.getOne(opportunityId));

            bookmarkDao.save(bookmark);

            one.getBookmarks().add(bookmark);
        }

        userDao.save(one);

        return Status.builder().newState(!aBoolean).build();
    }

    @PostMapping(path = "/api/v1/protected/user/submit_opportunity")
    public Status getAllBookMarks(Authentication authentication,
                                  @RequestParam(value = "title", required = false) String title,
                                  @RequestParam(value = "opportunity_type", required = false) OpportunityType opportunityType,
                                  @RequestParam(value = "funding_type", required = false) FundingType fundingType,
                                  @RequestParam(value = "region", required = false) Region region,
                                  @RequestParam(value = "deadline", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date deadline,
                                  @RequestParam(value = "image") MultipartFile image,
                                  @RequestParam(value = "eligibility", required = false) String eligibility,
                                  @RequestParam(value = "application_process", required = false) String applicationProcess,
                                  @RequestParam(value = "benefit", required = false) String benefit,
                                  @RequestParam(value = "other", required = false) String other,
                                  @RequestParam(value = "description", required = false) String description,
                                  @RequestParam(value = "url", required = false) String url,
                                  @RequestParam(value = "apply_url", required = false) String applyUrl
    ) {

        int length = 32;
        boolean useLetters = true;

        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        String imageName = generatedString + "." + S3AmazonService.getFileExtension(image.getOriginalFilename());

        s3AmazonService.uploadFile(image, imageName);

        Image imageEntity = new Image();
        imageEntity.setImageName(image.getOriginalFilename());
        imageEntity.setFile(imageName);

        Image savedImage = imageDao.save(imageEntity);

        SubmittedOpportunityEntity submittedOpportunityEntity = new SubmittedOpportunityEntity();

        submittedOpportunityEntity.setTitle(title);
        submittedOpportunityEntity.setOpportunityType(opportunityType);
        submittedOpportunityEntity.setFundingType(fundingType);
        submittedOpportunityEntity.setRegion(region);

        if (deadline != null) {
            submittedOpportunityEntity.setDeadline(new java.sql.Date(deadline.getTime()));
        }

        submittedOpportunityEntity.setImage(savedImage);
        submittedOpportunityEntity.setEligibility(eligibility);
        submittedOpportunityEntity.setApplication_process(applicationProcess);
        submittedOpportunityEntity.setBenefit(benefit);
        submittedOpportunityEntity.setOther(other);
        submittedOpportunityEntity.setDescription(description);
        submittedOpportunityEntity.setUrl(url);
        submittedOpportunityEntity.setApplyUrl(applyUrl);

        JwtUserDetails details = (JwtUserDetails) authentication.getPrincipal();

        User one = userDao.getOne(details.getId());
        submittedOpportunityEntity.setUser(one);

        submittedOpportunityDao.save(submittedOpportunityEntity);
        return Status.builder().status("Success").build();
    }

    @GetMapping("/api/v1/protected/user/submitted_opportunities")
    public List<Opportunity> getSubmittedOpportunities(Authentication authentication,
                                                       @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                       @RequestParam(value = "size", required = false, defaultValue = "10") int size) {

        JwtUserDetails principal = (JwtUserDetails) authentication.getPrincipal();
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id"));
        List<SubmittedOpportunityEntity> all = submittedOpportunityDao.findAllByUser(userDao.getOne(principal.getId()), pageRequest);

        return opportunityUtil.getOpportunityFromSubmittedEntityList(all);

    }

    @GetMapping("/api/v1/protected/user/approved_opportunities")
    public List<Opportunity> getApprovedOpportunities(Authentication authentication,
                                                      @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                      @RequestParam(value = "size", required = false, defaultValue = "10") int size) {

        JwtUserDetails principal = (JwtUserDetails) authentication.getPrincipal();
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id"));
        List<OpportunityEntity> all = opportunityDao.findAllByUser(userDao.getOne(principal.getId()), pageRequest);

        return opportunityUtil.getOpportunityFromEntityList(all);
    }
}
