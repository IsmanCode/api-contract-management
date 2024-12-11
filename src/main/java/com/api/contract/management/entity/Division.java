package com.api.contract.management.entity;

import com.api.contract.management.base.entity.BaseUuidEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@DynamicUpdate
@Setter
@Getter
@Entity(name = "division")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SQLDelete(sql = "UPDATE division SET deleted= true WHERE id = ?")
@SQLRestriction("deleted=false or deleted is null")
public class Division extends BaseUuidEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

}


