package com.ryf.appbackend.models.dto;

import com.ryf.appbackend.jpa.entities.CatagoryEntity;
import com.ryf.appbackend.jpa.entities.SubCatagoryEntity;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Article {


    private Long id;

    private String heading;

    private String headingType;

    private String headingLink;

    private String imageLink;

    private CatagoryEntity catagory;

    private List<SubCatagoryEntity> subCatagoryEntity;


}
