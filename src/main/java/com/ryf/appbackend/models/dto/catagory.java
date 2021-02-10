package com.ryf.appbackend.models.dto;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class catagory {

    private Long id;

    private String catagoryName;

}
