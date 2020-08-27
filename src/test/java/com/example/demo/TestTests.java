package com.example.demo;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Random;
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



//    @BeforeEach
    public void setup() throws Exception {
        TestEntity testEntity = new TestEntity();
        testEntity.setId(testId);
        testEntity.setNumber(UUID.randomUUID().version());
        testRepository.save(testEntity);
    }



    @Test
    void contextLoads() throws Exception {
        System.out.println("DemoApplicationTests.contextLoads");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/test/get2"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
