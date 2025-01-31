package com.api.contract.management.dto.response;

import com.api.contract.management.base.dto.response.BaseEntityResponse;
import lombok.Data;

import java.util.UUID;

@Data
public class ProjectDatatableResponse extends BaseEntityResponse {

    private UUID id;

    private String teamTitle;

    private String name;

    private String title;

}


