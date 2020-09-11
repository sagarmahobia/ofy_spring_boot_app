package com.ryf.appbackend.models.mappers;

import com.ryf.appbackend.jpa.entities.OpportunityEntity;
import com.ryf.appbackend.jpa.entities.user.SubmittedOpportunityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityToEntityMapper {
    EntityToEntityMapper INSTANCE = Mappers.getMapper(EntityToEntityMapper.class);

    @Mapping(target = "featured", ignore = true)
    @Mapping(target = "id", ignore = true)
    OpportunityEntity getOpportunityEntity(SubmittedOpportunityEntity submittedOpportunityEntity);

    SubmittedOpportunityEntity getSubmittedOpportunityEntity(OpportunityEntity submittedOpportunityEntity);


}
