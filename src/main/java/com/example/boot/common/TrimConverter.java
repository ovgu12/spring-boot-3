package com.example.boot.common;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class TrimConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String title) {
        return title.trim();
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData.trim();
    }
}
