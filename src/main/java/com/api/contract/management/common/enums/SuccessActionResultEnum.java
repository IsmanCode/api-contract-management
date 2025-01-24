package com.api.contract.management.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccessActionResultEnum {
    DELETE("200", "Deleted successfully"),
    CREATE("201", "Created successfully"),
    UPDATE("200", "Updated successfully");

    private String code;
    private String message;
}
