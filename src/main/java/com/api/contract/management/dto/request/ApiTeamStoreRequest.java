package com.api.contract.management.dto.request;

import com.api.contract.management.base.dto.request.ServiceRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiTeamStoreRequest implements ServiceRequest {
    @NotNull(message = "This Field is required")
    private UUID divisionId;
    @NotNull(message = "This Field is required")
    @NotBlank(message = "This Field is required")
    private String name;
    @NotNull(message = "This Field is required")
    @NotBlank(message = "This Field is required")
    private String title;
}
