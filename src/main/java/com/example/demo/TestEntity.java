package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "tbl_test")
public class TestEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long transactionId;

    @Column(name = "number")
    private int number;

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long id) {
        this.transactionId = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
