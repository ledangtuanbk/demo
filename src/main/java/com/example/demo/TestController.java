package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/test")
public class TestController {

    @Autowired
    TestRepository testRepository;

    @Autowired
    EntityManager entityManager;

//    //    @Transactional
//    @GetMapping(path = "/get")
//    public void test() throws InterruptedException {
////        System.out.println("TestController.test start");
////        System.out.println("TestController.test " + testRepository.getConnectionId());
////        testRepository.lock();
//        System.out.println("TestController.test " + testRepository.getConnectionId());
//
//        System.out.println("TestController.test " + testRepository.findAll().size());
//        Thread.sleep(20000);
////        testRepository.unlock();
////        System.out.println("TestController.test " + testRepository.findAll().size());
////        System.out.println("TestController.test end");
//    }

    @Transactional(rollbackFor = NullPointerException.class)
    @GetMapping(path = "/get3")
    public void test3() throws InterruptedException {
        System.out.println("TestController.test3");
        TestEntity byId = testRepository.findByTransactionId(testId);
        System.out.println(byId.getNumber());
    }

    @Autowired
    TestService testService;


    @Autowired
    MyPKRepository myPKRepository;

    Long testId = 10L;

    @Transactional
    @GetMapping(path = "/get2")
    public void test2() throws InterruptedException {
        System.out.println("TestController.test2");
        Long id = 10L;
        TestEntity testEntity = testRepository.findByTransactionId(id);
        System.out.println(testEntity.getTransactionId());
        testEntity.setNumber(5000);
//        testRepository.saveAndFlush(testEntity);
        testRepository.save(testEntity);
        System.out.println(testRepository.getNumber());
        System.out.println("after sleep testEntity.getNumber() = " + testEntity.getNumber());
    }

    @Transactional
    @GetMapping(path = "/get4")
    public TestPKEntity test4(){
        System.out.println("TestController.test4");
        Integer lineNumber = 2;
        List<TestPKEntity> byMyPK_lineNumber = myPKRepository.findByMyPK_LineNumber(lineNumber);
        System.out.println("byMyPK_lineNumber.size() = " + byMyPK_lineNumber.size());
        myPKRepository.deleteByMyPK_TransactionId(3L);
        TestPKEntity testPKEntity = new TestPKEntity();
        testPKEntity.setMyPK(new MyPK(3L,2));
        myPKRepository.save(testPKEntity);
        return testPKEntity;
    }


    @Transactional
    @GetMapping(path = "/get")
    public void test() throws InterruptedException {

    }

    public void notRequireNew() {
        TestEntity testEntity = new TestEntity();
        testEntity.setNumber(99);
        testRepository.saveAndFlush(testEntity);
    }
}
