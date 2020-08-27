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


@SpringBootTest
@AutoConfigureMockMvc
class TestPKTests {
    @Autowired
    TestRepository testRepository;

    @Autowired
    MyPKRepository myPKRepository;


    @Autowired
    private MockMvc mockMvc;

    Long testId = 1L;



    @BeforeEach
    public void setup() throws Exception {
        TestPKEntity testPKEntity = new TestPKEntity();
        TestPKEntity testPKEntity2 = new TestPKEntity();

        testPKEntity.setMyPK(new MyPK(3L, 2));
        testPKEntity.setName(UUID.randomUUID().toString());
        myPKRepository.save(testPKEntity);

//        testPKEntity2.setMyPK(new MyPK(2L, 2));
//        testPKEntity2.setName(UUID.randomUUID().toString());
//        myPKRepository.save(testPKEntity2);

    }
//
//    @AfterEach
//    public void tearDown() throws Exception {
//        testRepository.deleteById(testId);
//    }



    @Test
    void contextLoads() throws Exception {
        System.out.println("DemoApplicationTests.contextLoads");
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/test/get4"))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString()
//                .contains("TestPkEntity");
//        System.out.println(testRepository.findAll());
        this.mockMvc.perform(MockMvcRequestBuilders.get("/test/get4"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].myPK.transactionId", Matchers.is(2)));
    }
}
