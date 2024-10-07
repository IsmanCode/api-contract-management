package com.api.contract.management.dto.query.response;

import com.api.contract.management.entity.Team;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamResponse {

    private UUID id;

    private UUID divisionId;

    private String name;

    private String title;

    @JsonIgnore
    private Team entity;

}


