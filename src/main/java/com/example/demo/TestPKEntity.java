package com.example.demo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_pk")
public class TestPKEntity {

    @EmbeddedId
    private MyPK myPK;

    private String name;

    public TestPKEntity(MyPK myPK) {
        this.myPK = myPK;
    }

    public TestPKEntity() {

    }

    public MyPK getMyPK() {
        return myPK;
    }

    public void setMyPK(MyPK myPK) {
        this.myPK = myPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
