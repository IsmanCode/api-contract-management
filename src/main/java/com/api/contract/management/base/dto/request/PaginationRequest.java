package com.api.contract.management.base.dto.request;

import com.api.contract.management.base.enums.SortBy;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class PaginationRequest implements ServiceRequest {

    @NotNull
    protected int page = 1;

    @NotNull
    protected int size = 10;

    @NotNull
    @NotBlank
    protected String orderBy = "id";

    @NotNull
    @Enumerated(EnumType.STRING)
    protected SortBy sortBy = SortBy.DESC;
}
