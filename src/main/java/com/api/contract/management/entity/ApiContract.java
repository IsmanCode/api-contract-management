package com.api.contract.management.entity;

import com.api.contract.management.base.common.utils.JsonConverter;
import com.api.contract.management.base.entity.BaseUuidEntity;
import com.api.contract.management.common.enums.ApiContractStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Map;

@DynamicUpdate
@Setter
@Getter
@Entity(name = "api_contract")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ToString
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


