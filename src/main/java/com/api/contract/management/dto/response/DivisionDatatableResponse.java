package com.api.contract.management.dto.response;

import com.api.contract.management.base.dto.response.BaseEntityResponse;
import com.api.contract.management.common.enums.ApiContractStatusEnum;
import lombok.Data;

import java.util.UUID;

@Data
public class DivisionDatatableResponse extends BaseEntityResponse {

    private UUID id;

    private String name;

    private String title;

}


