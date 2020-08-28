package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {

    @Query(value = "select CountersIdId from CountersId where TableName = 'Sites' for update ;", nativeQuery = true)
    Integer lock();

    @Query(value = "unlock tables;", nativeQuery = true)
    Integer unlock();

    @Query(value = "select connection_id();", nativeQuery = true)
    Integer getConnectionId();

    @Query(value = "call getNumber();", nativeQuery = true)
    Integer getNumber();

    //    @Modifying(clearAutomatically = true)
//    @Modifying
//    @Query(value = "delete from TestEntity t where t.id = :id")
    @Modifying(clearAutomatically = true)
    @Query(value = "delete from TestEntity where transactionId = :id")
    void deleteByIdNative(@Param("id") Long id);

    @Modifying(clearAutomatically = true)
    @Query(value = "update TestEntity set number = 111 where transactionId = :id")
    void updateNative(@Param("id") Long id);

//    void deleteById(@Param("id") Long id);

//    void deleteB yId(Long id);

    TestEntity findByTransactionId(final Long id);

    @Query(nativeQuery = true, value = "select * from tbl_test where id = 10")
    Integer getNumber1();

    @Modifying
    void deleteByTransactionId(Long transactionId);
}