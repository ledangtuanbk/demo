package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

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
    @GetMapping(path = "/get2")
    public void test2() throws InterruptedException {

        System.out.println("TestController.test2 " + testRepository.findAll().size());
        NotrequireNew();
        requireNew();
        System.out.println("TestController.test2 " + testRepository.findAll().size());
        throw new NullPointerException("test");

//        testRepository.lock();
//        TestEntity testEntity1 = testRepository.findAll().get(0);
//        System.out.println(LocalTime.now() + ": TestController.test2 " + testEntity1.getId());
//        TestEntity lockEntity = entityManager.find(TestEntity.class, testEntity1.getId(), LockModeType.PESSIMISTIC_WRITE);
////        // get current max number
//        List<TestEntity> all = testRepository.findAll();
//        System.out.println(LocalTime.now() + ": TestController.test2 " + all.size());
//        Thread.sleep(5000);
//        entityManager.lock(lockEntity, LockModeType.NONE);
//        testRepository.unlock();

//        System.out.println("get all size " + all.size());
//        all.sort((o1, o2) -> o2.getNumber()-o1.getNumber());
//        int max = all.get(0).getNumber();
//        System.out.println(max);
//        max = max + 1;
//        Thread.sleep(1000);
//        TestEntity testEntity = new TestEntity();
//        testEntity.setNumber(max);
//        entityManager.persist(testEntity);
//        entityManager.flush();
//        entityManager.lock(lockEntity, LockModeType.NONE);
//        Thread.sleep(1000);
//        System.out.println("TestController.get2 start" );
//        testRepository.unlock();
//        System.out.println("TestController.get2 " + testRepository.findAll().size());
//        testRepository.save(new TestEntity());
//        System.out.println("TestController.get2 " + testRepository.findAll().size());
//        System.out.println("TestController.get2 end" );
    }

    @Transactional
    @GetMapping(path = "/get")
    public void test() throws InterruptedException {
        System.out.println("TestController.test2 " + testRepository.findAll().size());
        // se luu ban ghi nay 99
        NotrequireNew();

        // ban ghi voi number = 100 se dc luu vi no co require new
        requireNew();
        System.out.println("TestController.test2 " + testRepository.findAll().size());
        throw new NullPointerException("test");
    }

    public void NotrequireNew() {
        TestEntity testEntity = new TestEntity();
        testEntity.setNumber(99);
        testRepository.saveAndFlush(testEntity);
    }

    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void requireNew() {
        TestEntity testEntity = new TestEntity();
        testEntity.setNumber(100);
        testRepository.saveAndFlush(testEntity);
    }
}
