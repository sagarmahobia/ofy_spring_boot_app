package com.ryf.appbackend.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity(name = "banner")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BannerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "link",columnDefinition = "varchar(255) not null")
    private String link;

    @Column(name = "banner",columnDefinition = "varchar(255) not null")
    private String banner;
}
