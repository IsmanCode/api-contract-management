package com.api.contract.management.dto.request;

import com.api.contract.management.base.dto.request.ServiceRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiContractPublishRequest implements ServiceRequest {
    private UUID id;
}
