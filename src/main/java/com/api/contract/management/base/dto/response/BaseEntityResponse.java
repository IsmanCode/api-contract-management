package com.api.contract.management.base.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntityResponse implements Serializable{

    private Long createdDate;

    private Long updatedDate;

    private String createdBy;

    private String updatedBy;

}
