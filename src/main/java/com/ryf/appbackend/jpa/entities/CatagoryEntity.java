package com.ryf.appbackend.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Catagory")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CatagoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "catagory_name",columnDefinition = "varchar(255) not null unique")
    private String catagoryName;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "subCatagory_id")
    private List<SubCatagoryEntity> subCatagoryEntity;
}
