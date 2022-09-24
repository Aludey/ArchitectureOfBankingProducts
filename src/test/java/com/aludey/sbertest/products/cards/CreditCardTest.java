package com.aludey.sbertest.products.cards;

import com.aludey.sbertest.utils.Currency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    CreditCard creditCard;

    Currency initialCurrency = Currency.RUB;
    BigDecimal initialBalance = new BigDecimal(15000);
    String initialName = "Beneficial Credit Card";
    double initialPercentageRate = 0.15;

    @BeforeEach
    void createCreditCard(){
        creditCard = new CreditCard(initialCurrency, initialBalance, initialName, initialPercentageRate);
    }

    @Test
    void TestGetCurrencyMethod() {
        assertEquals(initialCurrency, creditCard.getCurrency(), "Currencies doesn't match");
    }

    @Test
    void testGetBalanceMethod() {
        assertEquals(initialBalance, creditCard.getBalance(), "Balances doesn't match");
    }

    @Test
    void testGetNameMethod() {
        assertEquals(initialName, creditCard.getName(), "Names doesn't match");
    }

    @Test
    void testGetPercentageRate() {
        assertEquals(initialPercentageRate, creditCard.getPercentageRate(), "Percentage Rates doesn't match");
    }

    @Test
    void testSetPercentageRateMethod() {
        double newPercentageRate = 0.25;
        creditCard.setPercentageRate(newPercentageRate);
        assertEquals(newPercentageRate, creditCard.getPercentageRate(),"Percentage Rates doesn't match");
    }

    @Test
    void testGetDebtMethod() {
        assertEquals(BigDecimal.ZERO, creditCard.getDebt(), "Debts doesn't match");
    }

    @Test
    void testGetInitialBalanceMethod() {
        assertEquals(initialBalance, creditCard.getInitialBalance(), "Initial Balances doesn't match");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0.01", "1", "100", "14999", "14999.99"})
    void testCommonWithdrawMethodWOException(BigDecimal withdrawMoney) {
        creditCard.withdraw(withdrawMoney);
        assertEquals(initialBalance.subtract(withdrawMoney), creditCard.getBalance(),"Balances doesn't match");
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "15000", "15999.99", "16000"})
    void testWithdrawMethodBalanceMoreThatInitialBalanceWOException(BigDecimal withdrawMoney) {
        BigDecimal deposit = new BigDecimal("1000");
        creditCard.deposit(deposit);
        creditCard.withdraw(withdrawMoney);
        assertEquals(initialBalance.add(deposit).subtract(withdrawMoney), creditCard.getBalance(),"Balances doesn't match");
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "1", "0.01"})
    void testWithdrawMethodException(BigDecimal addition) {
        Exception exception = assertThrows(ArithmeticException.class, () -> creditCard.withdraw(initialBalance.add(addition)));
        assertEquals("The balance is less than the requested amount!", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0.01", "1", "100"})
    void testDepositMethodOverInitialBalance(BigDecimal deposit) {
        creditCard.deposit(deposit);
        assertEquals(initialBalance.add(deposit), creditCard.getBalance(),"Balances doesn't match");
    }

    @ParameterizedTest
    @CsvSource({
            "'5000','2500'",
            "'1000', '1000'",
            "'0.02', '0.01'",
            "'100', '100.01'"
    })
    void testDepositMethodBalanceLessThanInitial(BigDecimal withdrawMoney, BigDecimal deposit) {
        creditCard.withdraw(withdrawMoney);
        creditCard.deposit(deposit);
        assertEquals(initialBalance.subtract(withdrawMoney).add(deposit), creditCard.getBalance(),"Balances doesn't match");
    }

    @Test
    void testChargePercentageMethod() {
        int initialDebt = 5000;
        creditCard.withdraw(new BigDecimal(initialDebt));
        assertEquals(new BigDecimal(initialDebt).multiply(BigDecimal.valueOf(1.15)), creditCard.chargePercentage(),"Debts doesn't match");
    }

    @ParameterizedTest
    @CsvSource({
            "'5000','2500', '2500'",
            "'1000', '1000', '0'",
            "'1000', '2000', '0'",
            "'100.02', '100.01', '0.01'",
            "'100', '100.01', '0'"
    })
    void testDebtRequestMethodFirstWithdrawThenDeposit(BigDecimal withdrawMoney, BigDecimal deposit, BigDecimal expectedDebt) {
        creditCard.withdraw(withdrawMoney);
        creditCard.deposit(deposit);
        assertEquals(expectedDebt, creditCard.debtRequest(),"Debts doesn't match");
    }

    @ParameterizedTest
    @CsvSource({
            "'5000','2500', '0'",
            "'1000', '1000', '0'",
            "'1000', '2000', '1000'",
            "'100.02', '100.01', '0'",
            "'100', '100.01', '0.01'"
    })
    void testDebtRequestMethodFirstDepositThenWithdraw(BigDecimal deposit, BigDecimal withdrawMoney, BigDecimal expectedDebt) {
        creditCard.deposit(deposit);
        creditCard.withdraw(withdrawMoney);
        assertEquals(expectedDebt, creditCard.getDebt(),"Debts doesn't match");
    }
}