package com.avananta.models;

import jakarta.persistence.PrePersist;

import java.util.Date;

public class MyListner {

    @PrePersist
    public void setCreatedAt(BaseModel entity) {
        entity.setCreatedAt(new Date());
    }
}