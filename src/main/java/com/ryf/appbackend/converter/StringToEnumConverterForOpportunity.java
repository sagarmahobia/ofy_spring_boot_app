package com.ryf.appbackend.converter;

import com.ryf.appbackend.jpa.entities.enums.OpportunityType;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverterForOpportunity implements Converter<String, OpportunityType> {


    @Override
    public OpportunityType convert(String s) {
        return OpportunityType.valueOf(s);
    }
}