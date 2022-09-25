package com.aludey.sbertest.products.cards;

import com.aludey.sbertest.utils.Currency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class DebitCardTest {

    DebitCard debitCard;

    final Currency currency = Currency.RUB;
    final BigDecimal initialBalance = new BigDecimal(1000);
    final String initialName = "Useful Debit Card Card";

    @BeforeEach
    void createDebitCard(){
        debitCard = new DebitCard(initialBalance, initialName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0.01", "1", "100"})
    void testDepositMethodOverInitialBalance(BigDecimal deposit) {
        debitCard.deposit(deposit);
        assertEquals(initialBalance.add(deposit), debitCard.getBalance(),"Balances doesn't match");
    }

    @ParameterizedTest
    @CsvSource({
            "'100','50'",
            "'100', '100'",
            "'0.02', '0.01'",
            "'100', '100.01'"
    })
    void testDepositMethodBalanceLessThanInitial(BigDecimal withdrawMoney, BigDecimal deposit) {
        debitCard.withdraw(withdrawMoney);
        debitCard.deposit(deposit);
        assertEquals(initialBalance.subtract(withdrawMoney).add(deposit), debitCard.getBalance(),"Balances doesn't match");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0.01","1", "100", "999", "999.99"})
    void testCommonWithdrawMethodWOException(BigDecimal withdrawMoney) {
        debitCard.withdraw(withdrawMoney);
        assertEquals(initialBalance.subtract(withdrawMoney), debitCard.getBalance(),"Balances doesn't match");
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "1999.99", "2000"})
    void testWithdrawMethodBalanceMoreThatInitialBalanceWOException(BigDecimal withdrawMoney) {
        BigDecimal deposit = new BigDecimal("1000");
        debitCard.deposit(deposit);
        debitCard.withdraw(withdrawMoney);
        assertEquals(initialBalance.add(deposit).subtract(withdrawMoney), debitCard.getBalance(),"Balances doesn't match");
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "1", "0.01"})
    void testWithdrawMethodException(BigDecimal addition) {
        Exception exception = assertThrows(ArithmeticException.class, () -> debitCard.withdraw(initialBalance.add(addition)));
        assertEquals("The balance is less than the requested amount!", exception.getMessage());
    }

    @Test
    void testGetCurrencyMethod() {
        assertEquals(currency, debitCard.getCurrency(), "Currencies doesn't match");
    }

    @Test
    void testGetBalanceMethod() {
        assertEquals(initialBalance, debitCard.getBalance(), "Balances doesn't match");
    }

    @Test
    void testFetNameMethod() {
        assertEquals(initialName, debitCard.getName(), "Names doesn't match");
    }
}