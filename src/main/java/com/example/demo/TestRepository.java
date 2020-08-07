package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {

    @Query(value = "lock tables tbl_test WRITE", nativeQuery = true)
    Integer lock();

    @Query(value = "unlock tables;", nativeQuery = true)
    Integer unlock();

    @Query(value = "select connection_id();", nativeQuery = true)
    Integer getConnectionId();
}
