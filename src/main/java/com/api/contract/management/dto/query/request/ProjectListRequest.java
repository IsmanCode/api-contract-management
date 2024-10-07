package com.api.contract.management.dto.query.request;

import com.api.contract.management.base.dto.request.ServiceRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectListRequest implements ServiceRequest {
    private UUID teamId;
}
