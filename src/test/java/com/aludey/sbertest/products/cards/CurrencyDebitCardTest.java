package com.aludey.sbertest.products.cards;

import com.aludey.sbertest.utils.Currency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyDebitCardTest {

    CurrencyDebitCard currencyDebitCard;

    Currency initialCurrency = Currency.USD;
    BigDecimal initialBalance = new BigDecimal(1000);
    String initialName = "Legit Currency Debit Card Card";

    @BeforeEach
    void createCreditCard(){
        currencyDebitCard = new CurrencyDebitCard(initialCurrency, initialBalance, initialName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0.01", "1", "100"})
    void testDepositMethodOverInitialBalance(BigDecimal deposit) {
        currencyDebitCard.deposit(deposit);
        assertEquals(initialBalance.add(deposit), currencyDebitCard.getBalance(),"Balances doesn't match");
    }

    @ParameterizedTest
    @CsvSource({
            "'100','50'",
            "'100', '100'",
            "'0.02', '0.01'",
            "'100', '100.01'"
    })
    void testDepositMethodBalanceLessThanInitial(BigDecimal withdrawMoney, BigDecimal deposit) {
        currencyDebitCard.withdraw(withdrawMoney);
        currencyDebitCard.deposit(deposit);
        assertEquals(initialBalance.subtract(withdrawMoney).add(deposit), currencyDebitCard.getBalance(),"Balances doesn't match");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0.01","1", "100", "999", "999.99"})
    void testCommonWithdrawMethodWOException(BigDecimal withdrawMoney) {
        currencyDebitCard.withdraw(withdrawMoney);
        assertEquals(initialBalance.subtract(withdrawMoney), currencyDebitCard.getBalance(),"Balances doesn't match");
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "1999.99", "2000"})
    void testWithdrawMethodBalanceMoreThatInitialBalanceWOException(BigDecimal withdrawMoney) {
        BigDecimal deposit = new BigDecimal("1000");
        currencyDebitCard.deposit(deposit);
        currencyDebitCard.withdraw(withdrawMoney);
        assertEquals(initialBalance.add(deposit).subtract(withdrawMoney), currencyDebitCard.getBalance(),"Balances doesn't match");
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "1", "0.01"})
    void testWithdrawMethodException(BigDecimal addition) {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            currencyDebitCard.withdraw(initialBalance.add(addition));
        });
        assertEquals("The balance is less than the requested amount!", exception.getMessage());
    }

    @Test
    void getCurrency() {
        assertEquals(initialCurrency, currencyDebitCard.getCurrency(), "Currencies doesn't match");
    }

    @Test
    void getBalance() {
        assertEquals(initialBalance, currencyDebitCard.getBalance(), "Balances doesn't match");
    }

    @Test
    void getName() {
        assertEquals(initialName, currencyDebitCard.getName(), "Names doesn't match");
    }
}