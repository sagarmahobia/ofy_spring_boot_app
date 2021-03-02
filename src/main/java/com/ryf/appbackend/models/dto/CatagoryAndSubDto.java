package com.ryf.appbackend.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CatagoryAndSubDto {

    private List<ArticleCatagoryDto> articleCatagoryDtoList;
    private List<SubCatagory> subCatagoryList;

}
