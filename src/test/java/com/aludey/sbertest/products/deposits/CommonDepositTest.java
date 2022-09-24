package com.aludey.sbertest.products.deposits;

import com.aludey.sbertest.utils.Currency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CommonDepositTest {


    CommonDeposit commonDeposit;

    Currency initialCurrency = Currency.EUR;
    BigDecimal initialBalance = new BigDecimal(1000);
    String initialName = "Some Common Deposit";

    @BeforeEach
    void createCommonDeposit(){
        commonDeposit = new CommonDeposit(initialCurrency, initialBalance, initialName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0.01", "1", "100"})
    void testDepositMethod(BigDecimal deposit) {
        commonDeposit.deposit(deposit);
        assertEquals(initialBalance.add(deposit), commonDeposit.getBalance(),"Balances doesn't match");
    }

    @Test
    void testGetCurrencyMethod() {
        assertEquals(initialCurrency, commonDeposit.getCurrency(), "Currencies doesn't match");
    }

    @Test
    void testGetBalanceMethod() {
        assertEquals(initialBalance, commonDeposit.getBalance(), "Balances doesn't match");
    }

    @Test
    void testGetNameMethod() {
        assertEquals(initialName, commonDeposit.getName(), "Names doesn't match");
    }

    @Test
    void testCloseDepositMethodWOException() {
        assertEquals("Active", commonDeposit.getStatus(),"Deposit wasn't Active");
        commonDeposit.closeDeposit();
        assertEquals(BigDecimal.ZERO, commonDeposit.getBalance(), "Balances is not zero");
        assertEquals("Closed", commonDeposit.getStatus(),"Deposit wasn't Closed");
    }

    @Test
    void testCloseDepositMethodException() {
        commonDeposit.closeDeposit();
        Exception exception = assertThrows(IllegalStateException.class, () -> commonDeposit.closeDeposit());
        assertEquals("Deposit is already closed!", exception.getMessage());
    }

    @Test
    void testGetStatusMethod() {
        assertEquals("Active", commonDeposit.getStatus(),"Statuses doesn't match");
    }
}