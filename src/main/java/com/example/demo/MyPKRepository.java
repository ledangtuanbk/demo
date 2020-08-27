package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyPKRepository extends JpaRepository<TestPKEntity, MyPK> {

    @Modifying
    @Query(value = "delete from TestPKEntity where myPK.transactionId = :transactionId")
    void deleteByTransactionId(@Param("transactionId") Long transactionId);

    @Modifying
    Integer deleteByMyPK_TransactionId(Long transactionId);

    @Modifying
    Integer deleteByMyPK_LineNumber(Integer lineNumber);

    @Modifying
    List<TestPKEntity> deleteAllByMyPK_LineNumber(Integer lineNumber);

    List<TestPKEntity> findByMyPK_LineNumber(Integer lineNumber);
}
