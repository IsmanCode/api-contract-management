package com.api.contract.management.entity;

import com.api.contract.management.base.entity.BaseUuidEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@DynamicUpdate
@Setter
@Getter
@Entity(name = "team")
@SQLDelete(sql = "UPDATE project SET deleted= true WHERE id = ?")
@SQLRestriction("deleted=false or deleted is null")
public class Team extends BaseUuidEntity {

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

}


