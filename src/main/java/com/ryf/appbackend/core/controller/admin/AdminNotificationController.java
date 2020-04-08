package com.ryf.appbackend.core.controller.admin;


import com.ryf.appbackend.jpa.dao.NotificationDao;
import com.ryf.appbackend.jpa.entities.notification.NotificationEntity;
import com.ryf.appbackend.models.dto.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AdminNotificationController {

    @Autowired
    NotificationDao notifications;

    @PostMapping(path = "/api/v1/protected/admin/notification/add")
    @ResponseBody
    public Status addNotification(
            @RequestParam("title") String title,
            @RequestParam("url") String url,
            @RequestParam("body") String body
    ) {

        NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setTitle(title);
        notificationEntity.setBody(body);
        notificationEntity.setUrl(url);

        notifications.save(notificationEntity);

        return Status.builder().status("Success").build();

    }

    @PostMapping(path = "/api/v1/protected/admin/notification/delete")
    @ResponseBody
    public Status addNotification(
            @RequestParam("id") int id) {

        notifications.deleteById(id);

        return Status.builder().status("Success").build();

    }


}
