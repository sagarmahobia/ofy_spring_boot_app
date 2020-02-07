package com.ryf.appbackend.controller.opportunity;

import com.ryf.appbackend.InvalidInputException;
import com.ryf.appbackend.controller.opportunity.models.Status;
import com.ryf.appbackend.jpa.dao.ImageDao;
import com.ryf.appbackend.jpa.dao.OpportunityDao;
import com.ryf.appbackend.jpa.entities.Image;
import com.ryf.appbackend.jpa.entities.OpportunityEntity;
import com.ryf.appbackend.jpa.entities.enums.FundingType;
import com.ryf.appbackend.jpa.entities.enums.OpportunityType;
import com.ryf.appbackend.jpa.entities.enums.Region;
import com.ryf.appbackend.jwtsecurity.model.JwtUser;
import com.ryf.appbackend.jwtsecurity.security.JwtUtil;
import com.ryf.appbackend.s3test.serviceimpl.AmazonClient;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;


@SuppressWarnings("Duplicates")
@CrossOrigin("*")
@RestController
public class ProtectedController {

    private final JwtUtil jwtUtil;
    private final OpportunityDao opportunityDao;
    private final ImageDao imageDao;
    private AmazonClient amazonClient;

    public ProtectedController(JwtUtil jwtUtil, OpportunityDao opportunityDao, ImageDao imageDao, AmazonClient amazonClient) {
        this.jwtUtil = jwtUtil;
        this.opportunityDao = opportunityDao;
        this.imageDao = imageDao;
        this.amazonClient = amazonClient;
    }


    @PostMapping(path = "/api/v1/public/login")
    @ResponseBody
    public Token getUser(@RequestParam("username") String user, @RequestParam("password") String password) {


        if (user.equals("sagar@ofy.com") && password.equals("Password")) {
            String generate = jwtUtil.generate(new JwtUser(100));
            Token token = new Token();
            token.token = generate;

            return token;
        } else {
            throw new InvalidInputException();
        }
    }

    @PostMapping(path = "/api/v1/protected/add_opportunity")
    @ResponseBody
    public Status addOpportunity(

            @RequestParam("title") String title,
            @RequestParam("opportunity_type") OpportunityType opportunityType,
            @RequestParam("funding_type") FundingType fundingType,
            @RequestParam("region") Region region,
            @RequestParam("deadline") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date deadline,
            @RequestParam("image") MultipartFile image,
            @RequestParam("eligibility") String eligibility,
            @RequestParam("application_process") String applicationProcess,
            @RequestParam("benefit") String benefit,
            @RequestParam("other") String other,
            @RequestParam("description") String description,
            @RequestParam("url") String url


    ) {

        int length = 32;
        boolean useLetters = true;

        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        String imageName = generatedString + "." + getFileExtension(image.getOriginalFilename());

        amazonClient.uploadFile(image, imageName);

        Image imageEntity = new Image();
        imageEntity.setImageName(image.getOriginalFilename());
        imageEntity.setFile(imageName);

        Image savedImage = imageDao.save(imageEntity);

        OpportunityEntity opportunityEntity = new OpportunityEntity();

        opportunityEntity.setTitle(title);
        opportunityEntity.setOpportunityType(opportunityType);
        opportunityEntity.setFundingType(fundingType);
        opportunityEntity.setRegion(region);
        opportunityEntity.setDeadline(new java.sql.Date(deadline.getTime()));
        opportunityEntity.setImage(savedImage);
        opportunityEntity.setEligibility(eligibility);
        opportunityEntity.setApplication_process(applicationProcess);
        opportunityEntity.setBenefit(benefit);
        opportunityEntity.setOther(other);
        opportunityEntity.setDescription(description);
        opportunityEntity.setUrl(url);

        opportunityDao.save(opportunityEntity);
        return new Status("SUCCESS");
    }

    @PostMapping(path = "/api/v1/protected/edit_opportunity")
    @ResponseBody
    public Status editOpportunity(
            @RequestParam("id") long id,
            @RequestParam("title") String title,
            @RequestParam("opportunity_type") OpportunityType opportunityType,
            @RequestParam("funding_type") FundingType fundingType,
            @RequestParam("region") Region region,
            @RequestParam("deadline") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date deadline,
            @RequestParam("eligibility") String eligibility,
            @RequestParam("application_process") String applicationProcess,
            @RequestParam("benefit") String benefit,
            @RequestParam("other") String other,
            @RequestParam("description") String description,
            @RequestParam("url") String url

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

        opportunityDao.save(opportunityEntity);

        return new Status("SUCCESS");
    }

    @PostMapping(path = "/api/v1/protected/edit_image")
    @ResponseBody
    public Status editImage(
            @RequestParam("id") long id,
            @RequestParam("image") MultipartFile newImage
    ) {

        OpportunityEntity one = opportunityDao.getOne(id);

        Image imageToDelete = one.getImage();

        amazonClient.deleteFileFromS3Bucket(imageToDelete.getFile());
        imageDao.delete(imageToDelete);


        int length = 32;
        boolean useLetters = true;

        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        String imageName = generatedString + "." + getFileExtension(newImage.getOriginalFilename());

        amazonClient.uploadFile(newImage, imageName);

        Image imageEntity = new Image();
        imageEntity.setImageName(newImage.getOriginalFilename());
        imageEntity.setFile(imageName);

        Image savedImage = imageDao.save(imageEntity);


        one.setImage(savedImage);

        opportunityDao.save(one);


        return new Status("SUCCESS");

    }

    @PostMapping(path = "/api/v1/protected/delete")
    @ResponseBody
    public Status deleteOpportunity(
            @RequestParam("id") long id
    ) {

        OpportunityEntity one = opportunityDao.getOne(id);

        Image image = one.getImage();

        amazonClient.deleteFileFromS3Bucket(image.getFile());
        imageDao.delete(image);
        opportunityDao.delete(one);

        return new Status("Success");
    }

    private static String getFileExtension(String fileName) {
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }

    class Token {
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
