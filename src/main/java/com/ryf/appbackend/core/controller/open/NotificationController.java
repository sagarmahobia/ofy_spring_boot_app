package com.ryf.appbackend.core.controller.open;


import com.ryf.appbackend.jpa.dao.NotificationDao;
import com.ryf.appbackend.models.dto.NotificationDTO;
import com.ryf.appbackend.models.mappers.EntityToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin("*")
@RestController
public class NotificationController {


    @Autowired
    NotificationDao notifications;

    @GetMapping(path = "/api/v1/public/notifications")
    @ResponseBody
    public List<NotificationDTO> getAllNotification() {

        return notifications.findAll().stream().map(
                EntityToDtoMapper.INSTANCE::getNotificationDto
        )
                .collect(Collectors.toList());
    }
}


