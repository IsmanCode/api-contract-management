package com.api.contract.management.entity;

import com.api.contract.management.base.entity.BaseUuidEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Setter
@Getter
@Entity(name = "project")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ToString
public class Project extends BaseUuidEntity {

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

}


