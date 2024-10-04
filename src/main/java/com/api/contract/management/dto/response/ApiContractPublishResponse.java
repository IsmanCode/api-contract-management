package com.api.contract.management.dto.response;

import com.api.contract.management.base.controller.dto.response.BaseResponse;
import lombok.Data;

import java.util.UUID;

@Data
public class ApiContractPublishResponse {
    private UUID id;
}
