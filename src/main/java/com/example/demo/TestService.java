package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void requireNew() {
        testRepository.lock();
        Integer number = testRepository.getNumber();
        System.out.println(number);
//        System.out.println("TestService.requireNew");
//        TestEntity testEntity = new TestEntity();
//        testEntity.setNumber(100);
//        System.out.println("save");
//        testRepository.save(testEntity);
//        System.out.println("after save");
//
////        if(true)
////        throw new RuntimeException("test");
//
//        TestEntity testEntity2 = new TestEntity();
//        testEntity2.setNumber(101);
//        testRepository.save(testEntity2);

        try {

//            System.out.println(LocalTime.now() + " start");
//            TestEntity testEntity = testRepository.findById(76L).get();
//            testEntity.setNumber(100);
//            testRepository.save(testEntity);
            Thread.sleep(5000);
            System.out.println(LocalTime.now() +  " done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
