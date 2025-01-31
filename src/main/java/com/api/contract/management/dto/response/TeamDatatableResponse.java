package com.api.contract.management.dto.response;

import com.api.contract.management.base.dto.response.BaseEntityResponse;
import lombok.Data;

import java.util.UUID;

@Data
public class TeamDatatableResponse extends BaseEntityResponse {

    private UUID id;

    private UUID divisionId;

    private String divisionTitle;

    private String name;

    private String title;

}


