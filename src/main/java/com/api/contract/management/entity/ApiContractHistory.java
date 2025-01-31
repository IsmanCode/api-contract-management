package com.api.contract.management.entity;

import com.api.contract.management.base.common.utils.JsonConverter;
import com.api.contract.management.base.entity.BaseUuidEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@DynamicUpdate
@Setter
@Getter
@Entity(name = "api_contract_history")
@SQLDelete(sql = "UPDATE division SET deleted= true WHERE id = ?")
@SQLRestriction("deleted=false or deleted is null")
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
    @ColumnTransformer(write = "?::jsonb")
    private Map<String, Object> openApiSpec;

}


