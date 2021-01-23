package com.ryf.appbackend.models.dto;

import lombok.*;

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

    private String catagory;

    private String subCatagory;


}
