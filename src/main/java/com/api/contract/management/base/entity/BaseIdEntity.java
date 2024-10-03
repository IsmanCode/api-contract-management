package com.api.contract.management.base.entity;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class BaseIdEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

}
