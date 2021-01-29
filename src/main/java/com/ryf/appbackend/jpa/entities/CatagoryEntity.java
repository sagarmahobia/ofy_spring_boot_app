package com.ryf.appbackend.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Catagory")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CatagoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "catagory_name",columnDefinition = "varchar(255) not null unique")
    private String catagoryName;


}
