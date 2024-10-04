package com.api.contract.management.entity;

import com.api.contract.management.base.entity.BaseIdEntity;
import com.api.contract.management.base.entity.BaseUuidEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Map;

@DynamicUpdate
@Setter
@Getter
@Entity(name = "api_contract_history")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@ToString
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

    @Type(type = "jsonb")
    @Column(name = "open_api_spec")
    private Map<String, Object> openApiSpec;

}


