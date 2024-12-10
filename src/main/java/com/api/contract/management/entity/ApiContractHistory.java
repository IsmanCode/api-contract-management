package com.api.contract.management.entity;

import com.api.contract.management.base.common.utils.JsonConverter;
import com.api.contract.management.base.entity.BaseUuidEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@DynamicUpdate
@Data
@Entity(name = "api_contract_history")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ApiContractHistory extends BaseUuidEntity {

    @ManyToOne
    @JoinColumn(name = "api_contract_id")
    private ApiContract apiContract;

    @Column(name = "name")
    private String name;

    @Column(name = "revision")
    private Integer revision;

    @Column(name = "version")
    private String version;

    @Convert(converter = JsonConverter.class)
    @Column(name = "open_api_spec")
    private Map<String, Object> openApiSpec;

}


