package com.api.contract.management.dto.response;

import com.api.contract.management.base.dto.response.BaseEntityResponse;
import com.api.contract.management.common.enums.ApiContractStatusEnum;
import lombok.Data;

import java.util.UUID;

@Data
public class ApiContractDatatableResponse extends BaseEntityResponse {

    private UUID id;

    private String divisionTitle;

    private String teamTitle;

    private String projectTitle;

    private String name;

    private Integer revision;

    private String version;

    private ApiContractStatusEnum status;

}


