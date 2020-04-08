package com.ryf.appbackend.jpa.entities.notification;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "notifications")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "url")
    private String url;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;


}
