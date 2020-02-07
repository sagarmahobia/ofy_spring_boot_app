package com.ryf.appbackend.config;


import com.ryf.appbackend.jpa.entities.enums.FundingType;
import com.ryf.appbackend.jpa.entities.enums.OpportunityType;
import com.ryf.appbackend.jpa.entities.enums.Region;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConverterConfig implements WebMvcConfigurer {


    @SuppressWarnings({"Convert2Lambda", "Anonymous2MethodRef"})
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, Region>() {
            @Override
            public Region convert(String name) {
                return Region.valueOf(name);
            }
        });
        registry.addConverter(new Converter<String, OpportunityType>() {
            @Override
            public OpportunityType convert(String name) {
                return OpportunityType.valueOf(name);
            }
        });
        registry.addConverter(new Converter<String, FundingType>() {
            @Override
            public FundingType convert(String name) {
                return FundingType.valueOf(name);
            }
        });

    }

}
