package com.ryf.appbackend.core.controller.admin;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.ryf.appbackend.core.services.ArticleService;
import com.ryf.appbackend.core.services.CatagoryService;
import com.ryf.appbackend.core.services.OpportunityUtil;
import com.ryf.appbackend.core.services.S3AmazonService;
import com.ryf.appbackend.jpa.dao.*;
import com.ryf.appbackend.jpa.entities.*;
import com.ryf.appbackend.jpa.entities.enums.*;
import com.ryf.appbackend.jpa.entities.user.SubmittedOpportunityEntity;
import com.ryf.appbackend.jpa.entities.user.User;
import com.ryf.appbackend.models.dto.Opportunity;
import com.ryf.appbackend.models.dto.Status;
import com.ryf.appbackend.models.dto.SubCatagory;
import com.ryf.appbackend.models.dto.catagory;
import com.ryf.appbackend.models.mappers.EntityToEntityMapper;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("Duplicates")
@CrossOrigin("*")
@RestController
public class ProtectedController {

    private final OpportunityDao opportunityDao;
    private final SubmittedOpportunityDao submittedOpportunityDao;
    private final ImageDao imageDao;
    private final ArticlesDao articlesDao;
    private final BannerDao bannerDao;
    private final ArticleService articleService;
    private final CatagoryService catagoryService;

    private S3AmazonService s3AmazonService;
    private UserDao userDao;
    private OpportunityUtil opportunityUtil;

    public ProtectedController(OpportunityDao opportunityDao, SubmittedOpportunityDao submittedOpportunityDao,
                               ImageDao imageDao, S3AmazonService s3AmazonService, UserDao userDao, OpportunityUtil opportunityUtil,
                               ArticlesDao articlesDao, BannerDao bannerDao,ArticleService articleService,CatagoryService catagoryService) {

        this.opportunityDao = opportunityDao;
        this.submittedOpportunityDao = submittedOpportunityDao;
        this.articlesDao = articlesDao;
        this.imageDao = imageDao;
        this.userDao = userDao;
        this.s3AmazonService = s3AmazonService;
        this.bannerDao = bannerDao;
        this.opportunityUtil = opportunityUtil;
        this.articleService = articleService;
        this.catagoryService = catagoryService;
    }

    @PostMapping(path = "/v1/protected/admin/add_opportunity")
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
            @RequestParam(value = "apply_url", required = false) String applyUrl) {

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
        opportunityEntity.setOrdering(0);

        opportunityDao.save(opportunityEntity);
        return Status.builder().status("Success").build();
    }

    @PostMapping(path = "/v1/protected/admin/edit_opportunity")
    @ResponseBody
    public Status editOpportunity(@RequestParam("id") long id,
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

    @PostMapping(path = "/v1/protected/admin/edit_submitted_opportunity")
    @ResponseBody
    public Status editSubmittedOpportunity(@RequestParam("id") long id,
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

        SubmittedOpportunityEntity opportunityEntity = submittedOpportunityDao.getOne(id);

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

        submittedOpportunityDao.save(opportunityEntity);

        return Status.builder().status("Success").build();
    }

    @PostMapping(path = "/v1/protected/admin/edit_image")
    @ResponseBody
    public Status editImage(@RequestParam("id") long id, @RequestParam("image") MultipartFile newImage) {

        OpportunityEntity one = opportunityDao.getOne(id);

        Image imageEntity = one.getImage();

        s3AmazonService.deleteFileFromS3Bucket(imageEntity.getFile());

        int length = 32;
        boolean useLetters = true;

        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        String imageName = generatedString + "." + S3AmazonService.getFileExtension(newImage.getOriginalFilename());

        s3AmazonService.uploadFile(newImage, imageName);

        imageEntity.setImageName(newImage.getOriginalFilename());
        imageEntity.setFile(imageName);

        Image savedImage = imageDao.save(imageEntity);

        one.setImage(savedImage);

        opportunityDao.save(one);

        return Status.builder().status("Success").build();

    }

    @PostMapping(path = "/v1/protected/admin/edit_submitted_image")
    @ResponseBody
    public Status editSubmittedImage(@RequestParam("id") long id, @RequestParam("image") MultipartFile newImage) {

        SubmittedOpportunityEntity one = submittedOpportunityDao.getOne(id);

        Image imageEntity = one.getImage();

        s3AmazonService.deleteFileFromS3Bucket(imageEntity.getFile());

        int length = 32;
        boolean useLetters = true;

        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        String imageName = generatedString + "." + S3AmazonService.getFileExtension(newImage.getOriginalFilename());

        s3AmazonService.uploadFile(newImage, imageName);

        imageEntity.setImageName(newImage.getOriginalFilename());
        imageEntity.setFile(imageName);

        Image savedImage = imageDao.save(imageEntity);

        one.setImage(savedImage);

        submittedOpportunityDao.save(one);

        return Status.builder().status("Success").build();

    }

    @PostMapping(path = "/v1/protected/admin/delete")
    @ResponseBody
    public Status deleteOpportunity(@RequestParam("id") long id) {

        OpportunityEntity one = opportunityDao.getOne(id);

        Image image = one.getImage();

        User user = one.getUser();
        if (user != null) {
            user.getApprovedOpportunities().remove(one);
            userDao.save(user);
        } else {
            opportunityDao.delete(one);
        }

        imageDao.delete(image);
        s3AmazonService.deleteFileFromS3Bucket(image.getFile());

        return Status.builder().status("Success").build();
    }

    @GetMapping(path = "/v1/protected/admin/approve")
    @ResponseBody
    public Status approveOpportunity(@RequestParam("id") long id) {

        SubmittedOpportunityEntity submittedOpportunityEntity = submittedOpportunityDao.getOne(id);

        OpportunityEntity opportunityEntity = EntityToEntityMapper.INSTANCE
                .getOpportunityEntity(submittedOpportunityEntity);

        opportunityEntity.setOrdering(0);

        User user = submittedOpportunityEntity.getUser();

        user.getSubmittedOpportunities().remove(submittedOpportunityEntity);

        opportunityDao.save(opportunityEntity);

        userDao.save(user);

        return Status.builder().status("Success").build();
    }

    @PostMapping(path = "/v1/protected/admin/toggle_featured")
    @ResponseBody
    public Status toggleFeatured(@RequestParam("id") long id) {

        OpportunityEntity one = opportunityDao.getOne(id);
        one.setFeatured(!one.getFeatured());
        opportunityDao.save(one);
        return Status.builder().status("Success").newState(one.getFeatured()).build();

    }

    @PostMapping(path = "/v1/protected/admin/users")
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @RequestMapping(path = "/v1/protected/admin/submitted_opportunity")
    @ResponseBody
    public Opportunity opportunity(@RequestParam("id") Long id) {
        return opportunityUtil.getOpportunityFromSubmittedEntity(submittedOpportunityDao.getOne(id));
    }


    @PostMapping("/v1/admin/add_catagory")
    public Status addCatagory(@RequestParam(value = "catagoryName",required = true) String catagoryName){

        catagoryService.saveCatagory(CatagoryEntity.builder()
                .catagoryName(catagoryName)
                .build());

        return Status.builder().status("Catagory saved").build();
    }

    @PostMapping("/v1/admin/add_subCatagorylist")
    public Status addSubCatagoryList(@RequestParam(required = true) Long catagoryId,
                                     @RequestBody List<String> subCatagoryList){

        List<SubCatagoryEntity> list = subCatagoryList.stream()
                .map(r-> SubCatagoryEntity.builder().parentCatagoryId(catagoryId).subCatagoryName(r).build())
                .collect(Collectors.toList());

        catagoryService.addSubCatagoryListtoCatagory(list);

        return Status.builder().status("SubCatagoryList added to Catagory").build();
    }

    @PostMapping("/v1/admin/add_subCatagory")
    public Status addSubCatagory(@RequestParam(value = "catagoryId",required = true) Long catagoryId,
                                 @RequestParam(value = "subCatagoryName",required = true) String subCatagoryName){

        catagoryService.addSubCatagorytoCatagory(SubCatagoryEntity.builder()
                .subCatagoryName(subCatagoryName)
                .parentCatagoryId(catagoryId)
                .build());

        return Status.builder().status("SubCatagory Added").build();
    }

    @PostMapping("/v1/admin/add_article")
    public Status addArticle(@RequestParam(value = "heading",required = false) String heading
            , @RequestParam(value = "headingType",required = false) String headingType
            , @RequestParam(value = "headingLink",required = false) String headingLink
            , @RequestParam(value = "imageLink",required = false) String imageLink
            , @RequestParam(value = "catagoryId",required = false) Long catagoryid


    ) {

        articleService.saveArticle(heading,headingLink,headingType,imageLink,catagoryid);


        return Status.builder().status("Success").build();
    }

    @PostMapping("/v1/admin/edit_article")
    public Status editArticle(@RequestParam(value = "id",required = true) Long id
            ,@RequestParam(value = "heading",required = false,defaultValue = "") String heading
            ,@RequestParam(value = "headingType",required = false,defaultValue = "") String headingType
            ,@RequestParam(value = "headingLink",required = false,defaultValue = "") String headingLink
            ,@RequestParam(value = "imageLink",required = false,defaultValue = "") String imageLink
            ,@RequestParam(value = "catagoryId",required = false,defaultValue = "null") Long catagoryid
    ){


        articleService.editArticle(id,headingLink,heading,headingType,imageLink,catagoryid);

        return Status.builder().status("Item edit Successful").build();
    }



    @DeleteMapping("/v1/protected/admin/delete_article")
    public Status deleteArticle(@RequestParam(value = "id",required = true) Long id){

        articlesDao.deleteById(id);

        return Status.builder().status("Article Deleted").build();
    }


    @PostMapping("/v1/protected/admin/add_banner")
    public Status addBanner(
                            @RequestParam(value = "link",required = true) String link,
                            @RequestParam(value = "banner",required = true) String banner
    ){

        bannerDao.save(BannerEntity.builder()
                .banner(banner)
                .link(link)
                .build());

        return Status.builder().status("Success").build();
    }

    @PostMapping("/v1/protected/admin/edit_banner")
    public Status editBanner(
                        @RequestParam(value = "id",required = true) Long id,
                        @RequestParam(value = "link",required = true) String link,
                        @RequestParam(value = "banner",required = true) String banner
    ){
        BannerEntity entity = bannerDao.getOne(id);
        entity.setBanner(banner);
        entity.setLink(link);

        bannerDao.save(entity);


        return Status.builder().status("banner edit successful").build();
    }

    @DeleteMapping("/v1/protected/admin/delete_banner")
    public Status deleteBanner(@RequestParam(value = "id",required = true) Long id){
        bannerDao.deleteById(id);

        return Status.builder().status("Banner Deleted").build();
    }



}
