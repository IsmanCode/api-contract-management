package com.api.contract.management.entity;

import com.api.contract.management.base.common.utils.JsonConverter;
import com.api.contract.management.base.entity.BaseUuidEntity;
import com.api.contract.management.common.enums.ApiContractStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.Instant;
import java.util.Map;

@DynamicUpdate
@Setter
@Getter
@Entity(name = "api_contract")
@SQLDelete(sql = "UPDATE division SET deleted= true WHERE id = ?")
@SQLRestriction("deleted=false or deleted is null")
public class ApiContract extends BaseUuidEntity {

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "name")
    private String name;

    @Column(name = "revision")
    private Integer revision;

    @Column(name = "version")
    private String version;

    @Convert(converter = JsonConverter.class)
    @Column(name = "open_api_spec")
    private Map<String, Object> openApiSpec;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ApiContractStatusEnum status;

}


