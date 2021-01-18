package com.ryf.appbackend.models.dto;


import com.ryf.appbackend.jpa.entities.enums.FundinType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Category {

    private String id;

    private String title;

    private String image;

    private FundinType opportunityType;

    public Category(FundinType type, String image) {
        this.opportunityType = type;
        this.id = type.toString();
        this.title = type.getName();
        this.image = image;
    }

}
