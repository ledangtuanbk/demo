package com.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {
    @Autowired
    TestRepository testRepository;


    @Autowired
    private MockMvc mockMvc;

    Long testId = 1L;



//    @BeforeEach
//    public void setup() throws Exception {
//        TestEntity testEntity = new TestEntity();
//        testEntity.setId(testId);
//        testEntity.setNumber(999);
//        testRepository.save(testEntity);
//    }
//
//    @AfterEach
//    public void tearDown() throws Exception {
//        testRepository.deleteById(testId);
//    }



    @Test
    void contextLoads() throws Exception {
        System.out.println("DemoApplicationTests.contextLoads");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/test/get2"));
        System.out.println(testRepository.findAll());
    }
}
