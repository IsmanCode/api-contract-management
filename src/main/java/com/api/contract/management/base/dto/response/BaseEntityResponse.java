package com.api.contract.management.base.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntityResponse implements Serializable{

    private Date createdDate;

    private Date updatedDate;

    private String createdBy;

    private String updatedBy;

}
