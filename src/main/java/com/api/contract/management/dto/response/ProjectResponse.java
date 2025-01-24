package com.api.contract.management.dto.response;

import com.api.contract.management.entity.Project;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectResponse {

    private UUID id;

    private UUID teamId;

    private String name;

    private String title;

    @JsonIgnore
    private Project entity;

}


