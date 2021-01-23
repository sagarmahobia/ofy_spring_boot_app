package com.ryf.appbackend.jpa.entities;

import lombok.*;

import javax.persistence.*;

@Entity(name = "Articles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ArticlesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "heading",columnDefinition = "varchar(255) not null")
    private String heading;

    @Column(name = "heading_type",columnDefinition = "varchar(255) not null")
    private String headingType;

    @Column(name = "heading_link",columnDefinition = "varchar(255) not null")
    private String headingLink;

    @Column(name = "image_link",columnDefinition = "varchar(255) not null")
    private String imageLink;

    @Column(name = "catagory")
    private String catagory;

    @Column(name = "sub_catagory")
    private String subCatagory;

}
