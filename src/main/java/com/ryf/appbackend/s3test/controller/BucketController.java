package com.ryf.appbackend.s3test.controller;


import com.ryf.appbackend.s3test.serviceimpl.AmazonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class BucketController {

    private AmazonClient amazonClient;

    @Autowired
    BucketController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("/uploadFile")
    public void uploadFile(@RequestPart(value = "file") MultipartFile file) throws IOException {
//        return this.amazonClient.uploadFile(file);
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "fileName") String fileName) {
        return this.amazonClient.deleteFileFromS3Bucket(fileName);
    }
}