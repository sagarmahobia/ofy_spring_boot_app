package com.ryf.appbackend.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubCatagory {

    private Long id;

    private String subCatagoryName;

    private Long parentCatagoryId;
}
