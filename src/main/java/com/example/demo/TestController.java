package com.example.demo;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

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

//        System.out.println("TestController.test2 " + testRepository.findAll().size());
//        NotrequireNew();
//        requireNew();
//        System.out.println("TestController.test2 " + testRepository.findAll().size());
//        throw new NullPointerException("test");

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

    @Autowired
    TestService testService;


    @Autowired
    MyPKRepository myPKRepository;

    @Transactional
    @GetMapping(path = "/get2")
    public void test2(){
        TestPKEntity testPKEntity = new TestPKEntity();
        testPKEntity.setMyPK(new MyPK(1L,1));
        testPKEntity.setName(UUID.randomUUID().toString());
        myPKRepository.save(testPKEntity);
    }


    @Transactional
    @GetMapping(path = "/get")
    public void test() throws InterruptedException {
//        System.out.println("hello");
        Long id = 92L;
////        testRepository.deleteById(id);
////        TestEntity testEntity1 = new TestEntity();
//////        testEntity1.setId(id);
////        testRepository.save(testEntity1);
//        Optional<TestEntity> byId = testRepository.findById(id);
//        if(byId.isPresent()){
//            TestEntity testEntity = byId.get();
//            System.out.println("TestController.test " + testEntity.getId() );
//            testRepository.delete(testEntity);
////            testRepository.deleteById(id);
//
//            TestEntity testEntity1 = new TestEntity();
//            testEntity1.setId(id);
//            testRepository.save(testEntity1);
//
//        }
//        System.out.println("TestController.test done");
        testRepository.findById(id).ifPresent(testEntity -> System.out.println("testEntity.getId() = " + testEntity.getId()));
        testRepository.deleteById(id);
        TestEntity testEntity1 = new TestEntity();
        testEntity1.setId(id);
        testRepository.save(testEntity1);
    }

    public void notRequireNew() {
        TestEntity testEntity = new TestEntity();
        testEntity.setNumber(99);
        testRepository.saveAndFlush(testEntity);
    }
}
