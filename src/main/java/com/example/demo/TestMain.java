package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

public class TestMain {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-application-context.xml");
//        SampleAdder sampleAdder = context.getBean(SampleAdder.class);
//        sampleAdder.add(1,2);
//        sampleAdder.sub(1,2);
//        sampleAdder.divide(1,0);
        LocalDate localDate = LocalDate.ofEpochDay(0L);
        System.out.println(localDate);
    }
}
