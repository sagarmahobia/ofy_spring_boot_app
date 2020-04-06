package com.ryf.appbackend.jpa.dao;

import com.ryf.appbackend.jpa.entities.notification.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationDao extends JpaRepository<NotificationEntity, Integer> {
}


