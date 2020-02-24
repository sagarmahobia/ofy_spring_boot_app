package com.ryf.appbackend.core.controller.admin;

import com.ryf.appbackend.core.controller.models.Status;
import com.ryf.appbackend.core.services.S3AmazonService;
import com.ryf.appbackend.jpa.dao.ImageDao;
import com.ryf.appbackend.jpa.dao.OpportunityDao;
import com.ryf.appbackend.jpa.dao.UserDao;
import com.ryf.appbackend.jpa.entities.Image;
import com.ryf.appbackend.jpa.entities.OpportunityEntity;
import com.ryf.appbackend.jpa.entities.enums.FundingType;
import com.ryf.appbackend.jpa.entities.enums.OpportunityType;
import com.ryf.appbackend.jpa.entities.enums.Region;
import com.ryf.appbackend.jpa.entities.user.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;


@SuppressWarnings("Duplicates")
@CrossOrigin("*")
@RestController
public class ProtectedController {

    private final OpportunityDao opportunityDao;
    private final ImageDao imageDao;
    private S3AmazonService s3AmazonService;
    private UserDao userDao;

    public ProtectedController(OpportunityDao opportunityDao, ImageDao imageDao, S3AmazonService s3AmazonService, UserDao userDao) {
        this.opportunityDao = opportunityDao;
        this.imageDao = imageDao;
        this.userDao = userDao;
        this.s3AmazonService = s3AmazonService;
    }


    @PostMapping(path = "/api/v1/protected/admin/add_opportunity")
    @ResponseBody
    public Status addOpportunity(

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

        String imageName = generatedString + "." + getFileExtension(image.getOriginalFilename());

        s3AmazonService.uploadFile(image, imageName);

        Image imageEntity = new Image();
        imageEntity.setImageName(image.getOriginalFilename());
        imageEntity.setFile(imageName);

        Image savedImage = imageDao.save(imageEntity);

        OpportunityEntity opportunityEntity = new OpportunityEntity();

        opportunityEntity.setTitle(title);
        opportunityEntity.setOpportunityType(opportunityType);
        opportunityEntity.setFundingType(fundingType);
        opportunityEntity.setRegion(region);

        if (deadline != null) {
            opportunityEntity.setDeadline(new java.sql.Date(deadline.getTime()));
        }

        opportunityEntity.setImage(savedImage);
        opportunityEntity.setEligibility(eligibility);
        opportunityEntity.setApplication_process(applicationProcess);
        opportunityEntity.setBenefit(benefit);
        opportunityEntity.setOther(other);
        opportunityEntity.setDescription(description);
        opportunityEntity.setUrl(url);
        opportunityEntity.setApplyUrl(applyUrl);

        opportunityDao.save(opportunityEntity);
        return Status.builder().status("Success").build();
    }

    @PostMapping(path = "/api/v1/protected/admin/edit_opportunity")
    @ResponseBody
    public Status editOpportunity(
            @RequestParam("id") long id,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "opportunity_type", required = false) OpportunityType opportunityType,
            @RequestParam(value = "funding_type", required = false) FundingType fundingType,
            @RequestParam(value = "region", required = false) Region region,
            @RequestParam(value = "deadline", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date deadline,
            @RequestParam(value = "eligibility", required = false) String eligibility,
            @RequestParam(value = "application_process", required = false) String applicationProcess,
            @RequestParam(value = "benefit", required = false) String benefit,
            @RequestParam(value = "other", required = false) String other,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "url", required = false) String url,
            @RequestParam(value = "apply_url", required = false) String applyUrl

    ) {


        OpportunityEntity opportunityEntity = opportunityDao.getOne(id);

        opportunityEntity.setTitle(title);
        opportunityEntity.setOpportunityType(opportunityType);
        opportunityEntity.setFundingType(fundingType);
        opportunityEntity.setRegion(region);
        opportunityEntity.setDeadline(new java.sql.Date(deadline.getTime()));
        opportunityEntity.setEligibility(eligibility);
        opportunityEntity.setApplication_process(applicationProcess);
        opportunityEntity.setBenefit(benefit);
        opportunityEntity.setOther(other);
        opportunityEntity.setDescription(description);
        opportunityEntity.setUrl(url);
        opportunityEntity.setApplyUrl(applyUrl);

        opportunityDao.save(opportunityEntity);

        return Status.builder().status("Success").build();
    }

    @PostMapping(path = "/api/v1/protected/admin/edit_image")
    @ResponseBody
    public Status editImage(
            @RequestParam("id") long id,
            @RequestParam("image") MultipartFile newImage
    ) {

        OpportunityEntity one = opportunityDao.getOne(id);

        Image imageEntity = one.getImage();

        s3AmazonService.deleteFileFromS3Bucket(imageEntity.getFile());

        int length = 32;
        boolean useLetters = true;

        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        String imageName = generatedString + "." + getFileExtension(newImage.getOriginalFilename());

        s3AmazonService.uploadFile(newImage, imageName);

        imageEntity.setImageName(newImage.getOriginalFilename());
        imageEntity.setFile(imageName);

        Image savedImage = imageDao.save(imageEntity);


        one.setImage(savedImage);

        opportunityDao.save(one);


        return Status.builder().status("Success").build();

    }

    @PostMapping(path = "/api/v1/protected/admin/delete")
    @ResponseBody
    public Status deleteOpportunity(
            @RequestParam("id") long id
    ) {

        OpportunityEntity one = opportunityDao.getOne(id);

        Image image = one.getImage();

        opportunityDao.delete(one);
        imageDao.delete(image);
        s3AmazonService.deleteFileFromS3Bucket(image.getFile());

        return Status.builder().status("Success").build();
    }

    @PostMapping(path = "/api/v1/protected/admin/toggle_featured")
    @ResponseBody
    public Status toggleFeatured(
            @RequestParam("id") long id
    ) {

        OpportunityEntity one = opportunityDao.getOne(id);
        one.setFeatured(!one.getFeatured());
        opportunityDao.save(one);
        return Status.builder().status("Success").newState(one.getFeatured()).build();

    }

    @PostMapping(path = "/api/v1/protected/admin/users")
    public List<User> getUsers() {
        return userDao.findAll();
    }


    private static String getFileExtension(String fileName) {
        int lastIndexOf = fileName.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf != 0)
            return fileName.substring(lastIndexOf + 1);
        else return "";
    }

}
