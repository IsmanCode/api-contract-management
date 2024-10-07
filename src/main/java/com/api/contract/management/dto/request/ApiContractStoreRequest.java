package com.api.contract.management.dto.request;

import com.api.contract.management.base.dto.request.ServiceRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiContractStoreRequest implements ServiceRequest {
    @NotNull(message = "This Field is required")
    @NotBlank(message = "This Field is required")
    private String divisionId;
    @NotNull(message = "This Field is required")
    @NotBlank(message = "This Field is required")
    private String teamId;
    @NotNull(message = "This Field is required")
    @NotBlank(message = "This Field is required")
    private String projectId;
    @NotNull(message = "This Field is required")
    @NotBlank(message = "This Field is required")
    private String contractName;
    @NotNull( message = "This Field is required")
    @NotBlank(message = "This Field is required")
    private String version;
}
