package com.api.contract.management.base.common.utils;

import com.api.contract.management.common.util.ObjectMapperUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class JsonConverter<T> implements AttributeConverter<T, String> {

    @Override
    public String convertToDatabaseColumn(T attribute) {
            return ObjectMapperUtil.convertToString(attribute);
    }

    @Override
    public T convertToEntityAttribute(String dbData) {
            return ObjectMapperUtil.convertToObject(dbData, new TypeReference<T>() {});
    }
}