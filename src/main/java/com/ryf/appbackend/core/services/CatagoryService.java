package com.ryf.appbackend.core.services;


import com.ryf.appbackend.jpa.dao.CatagoryDao;
import com.ryf.appbackend.jpa.dao.SubCatagoryDao;
import com.ryf.appbackend.jpa.entities.CatagoryEntity;
import com.ryf.appbackend.jpa.entities.SubCatagoryEntity;
import com.ryf.appbackend.models.dto.ArticleCatagoryDto;
import com.ryf.appbackend.models.dto.SubCatagory;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CatagoryService {

    private CatagoryDao catagoryDao;
    private SubCatagoryDao subCatagoryDao;

    public CatagoryService(CatagoryDao catagoryDao, SubCatagoryDao subCatagoryDao){
        this.catagoryDao = catagoryDao;
        this.subCatagoryDao = subCatagoryDao;
    }

    public ArticleCatagoryDto convertEntitytoDto(CatagoryEntity catagoryEntity){

        return ArticleCatagoryDto.builder()
                .catagoryName(catagoryEntity.getCatagoryName())
                .id(catagoryEntity.getId())
                .build();
    }

    public SubCatagory convertSubCatagoryEntitytoDto(SubCatagoryEntity subCatagoryEntity){

        return SubCatagory.builder()
                .id(subCatagoryEntity.getId())
                .subCatagoryName(subCatagoryEntity.getSubCatagoryName())
                .parentCatagoryId(subCatagoryEntity.getParentCatagoryId())
                .build();
    }

    public void saveCatagory(CatagoryEntity catagoryEntity){
        catagoryDao.save(catagoryEntity);
    }

    @Transactional
    public void addSubCatagorytoCatagory(SubCatagoryEntity subCatagoryEntity){

        SubCatagoryEntity subCatagoryEntity1 = subCatagoryDao.save(subCatagoryEntity);

        CatagoryEntity catagoryEntity = catagoryDao.getOne(subCatagoryEntity.getParentCatagoryId());

        catagoryEntity.getSubCatagoryEntity().add(subCatagoryEntity1);

        catagoryDao.save(catagoryEntity);

    }

    @Transactional
    public void addSubCatagoryListtoCatagory(List<SubCatagoryEntity> subCatagoryEntityList){

       List<SubCatagoryEntity> list = subCatagoryEntityList.stream()
                .map(subCatagoryDao::save)
                .collect(Collectors.toList());

       CatagoryEntity catagoryEntity = catagoryDao.getOne(subCatagoryEntityList.get(0).getParentCatagoryId());

       list.stream()
               .forEach(catagoryEntity.getSubCatagoryEntity()::add);

       catagoryDao.save(catagoryEntity);

    }


    public List<ArticleCatagoryDto> getAllCatagories() {




            return catagoryDao.findAll()
                    .parallelStream()
                    .map(this::convertEntitytoDto)
                    .collect(Collectors.toList());




    }

    public List<SubCatagory> getAllSubCatagories(){

        return subCatagoryDao.findAll()
                .parallelStream()
                .map(this::convertSubCatagoryEntitytoDto)
                .collect(Collectors.toList());
    }
}
