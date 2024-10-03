package com.api.contract.management.base.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RequestType {
    HTTP("Http"),
    KAFKA("Kafka"),
    RABBITMQ("RabbitMQ");

    private String code;
}
