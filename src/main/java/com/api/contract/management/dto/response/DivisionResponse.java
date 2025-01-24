package com.api.contract.management.dto.response;

import com.api.contract.management.base.entity.BaseUuidEntity;
import com.api.contract.management.entity.Division;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DivisionResponse  {

    private UUID id;

    private String name;

    private String title;

    @JsonIgnore
    private Division entity;

}


