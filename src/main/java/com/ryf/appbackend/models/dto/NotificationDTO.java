package com.ryf.appbackend.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationDTO {
    private int id;
    private String url;
    private String title;
    private String body;
}
