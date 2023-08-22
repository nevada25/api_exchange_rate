package com.ibk.interbank.apiexchangerate.entity.audit;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;

@MappedSuperclass
public class Auditable {

    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createDate;



    @Column(name = "modified_date")
    @CreatedDate
    private LocalDateTime modifiedDate;

    @Column(name = "create_by")
    @CreatedBy
    private String createBy;

    @Column(name = "modify_by")
    @LastModifiedBy
    private String modifyUser;
}
