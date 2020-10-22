package com.ryf.appbackend.models.mappers;

import com.ryf.appbackend.jpa.entities.notification.NotificationEntity;
import com.ryf.appbackend.models.dto.NotificationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityToDtoMapper {
    EntityToDtoMapper INSTANCE = Mappers.getMapper(EntityToDtoMapper.class);

    NotificationDTO getNotificationDto(NotificationEntity notificationEntity);

}
