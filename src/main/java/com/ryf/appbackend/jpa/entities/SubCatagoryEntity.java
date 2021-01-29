package com.ryf.appbackend.jpa.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "sub_catagory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubCatagoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subcatagory_Name",columnDefinition = "varchar(255) not null unique")
    private String subCatagoryName;


}
