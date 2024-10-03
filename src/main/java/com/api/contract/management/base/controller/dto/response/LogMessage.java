package com.api.contract.management.base.controller.dto.response;

import lombok.Data;

@Data
public class LogMessage {

    private int httpStatus;

    private String httpMethod;

    private String path;

    private String clientIp;

    private String javaMethod;

    private String request;

    private String response;

}
