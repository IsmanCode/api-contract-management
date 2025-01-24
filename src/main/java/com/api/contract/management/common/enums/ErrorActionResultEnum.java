package com.api.contract.management.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorActionResultEnum {
    NOT_FOUND("404", "Data not found!");

    private String code;
    private String message;
}
