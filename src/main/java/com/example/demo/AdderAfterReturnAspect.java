package com.example.demo;

public class AdderAfterReturnAspect {
    public void doAfterReturning(Object result) throws Throwable{
        System.out.println("return object " + result);
    }
}
