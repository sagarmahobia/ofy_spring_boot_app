package com.ryf.appbackend.jpa.entities.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ryf.appbackend.jpa.entities.OpportunityEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "bookmarks")
@Getter
@Setter
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "opportunity_id")
    @OneToOne(fetch = FetchType.LAZY)
    OpportunityEntity opportunity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

}
