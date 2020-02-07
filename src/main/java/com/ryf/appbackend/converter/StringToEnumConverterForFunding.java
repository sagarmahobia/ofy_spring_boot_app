package com.ryf.appbackend.converter;

import com.ryf.appbackend.jpa.entities.enums.FundingType;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverterForFunding implements Converter<String, FundingType> {

    @Override
    public FundingType convert(String s) {
        return FundingType.valueOf(s);
    }
}
