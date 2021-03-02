package com.ryf.appbackend.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCatagoryDto {

    private Long id;

    private String catagoryName;

    private List<SubCatagory> subCatagoryList;
}
