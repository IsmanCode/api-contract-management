package com.api.contract.management.base.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.util.UUID;

@MappedSuperclass
@Data
public class BaseUuidEntity extends BaseEntity {

    @Id
    @Column(name="ID", columnDefinition = "UUID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

}
