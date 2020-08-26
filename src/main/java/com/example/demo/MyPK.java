package com.example.demo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MyPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Basic(optional = false)
    @Column(name = "line_number")
    private Integer lineNumber;

    public MyPK(){

    }

    public MyPK(Long transactionId, Integer lineNumber) {
        this.transactionId = transactionId;
        this.lineNumber = lineNumber;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }
}
