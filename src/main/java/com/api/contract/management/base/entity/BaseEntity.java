package com.api.contract.management.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable{

    @Column(name = "DELETED")
    private Boolean deleted;

    @Column(name = "CREATED_DATE")
    private Long createdDate;

    @Column(name = "UPDATED_DATE")
    private Long updatedDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "UPDATED_BY")
    private String updatedBy;
}
