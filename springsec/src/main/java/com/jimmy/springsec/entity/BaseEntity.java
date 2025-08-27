package com.jimmy.springsec.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

    @CreatedDate
    @JsonIgnore
    private LocalDateTime createdAt;

    @CreatedBy
    @JsonIgnore
    private String createdBy;

    @LastModifiedDate
    @JsonIgnore
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @JsonIgnore
    private String updatedBy;

}
