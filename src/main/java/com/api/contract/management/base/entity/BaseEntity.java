package com.api.contract.management.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable{

    @Column(name = "CREATE_DATE", updatable = false)
    private Date createDate;

    @Column(name = "UPDATE_DATE", insertable = false)
    private Date updateDate;

    @Column(name = "CREATE_DATE", updatable = false)
    private String createBy;

    @Column(name = "UPDATE_DATE", insertable = false)
    private String updateBy;
}
