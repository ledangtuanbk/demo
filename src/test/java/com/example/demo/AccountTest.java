//package com.example.demo;
//
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class AccountTest {
//    private Account account;
//
//    @Before
//    public void before() {
//        account = new Account();
//    }
//
//    @Test
//    public void given20AndMin10_whenWithdraw5_thenSuccess() {
//        assertTrue(account.withdraw(5));
//    }
//
//    @Test
//    public void given20AndMin10_whenWithdraw100_thenFail() {
//        assertFalse(account.withdraw(100));
//    }
//}