package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
class TestTests {
    @Autowired
    TestRepository testRepository;

    @Autowired
    MyPKRepository myPKRepository;


    @Autowired
    private MockMvc mockMvc;

    Long testId = 10L;



    @BeforeEach
    public void setup() throws Exception {
        TestEntity testEntity = new TestEntity();
        testEntity.setTransactionId(testId);
        testEntity.setNumber(UUID.randomUUID().version());
        testRepository.save(testEntity);
    }



    @Test
    void contextLoads() throws Exception {
        System.out.println("DemoApplicationTests.contextLoads");
        mockMvc.perform(MockMvcRequestBuilders.get("/test/get2"))
                .andExpect(MockMvcResultMatchers.status().isOk());
//        new Thread(() -> {
//            try {
//                mockMvc.perform(MockMvcRequestBuilders.get("/test/get2"))
//                        .andExpect(MockMvcResultMatchers.status().isOk());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }).start();
//        Thread.sleep(100);
//        new Thread(()->{
//            try {
//                mockMvc.perform(MockMvcRequestBuilders.get("/test/get3"))
//                        .andExpect(MockMvcResultMatchers.status().isOk());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }).start();


    }
}
