package com.aludey.sbertest.products.cards;

import com.aludey.sbertest.utils.Currency;

import java.math.BigDecimal;

public class CreditCard extends AbstractCard {

    private double percentageRate;

    private final BigDecimal initialBalance;

    private BigDecimal debt = BigDecimal.ZERO;


    public CreditCard() {
        currency = Currency.RUB;
        balance = new BigDecimal("50000");
        initialBalance = this.balance;
        name = "Default Credit Card";
        percentageRate = 0.2;
    }

    public CreditCard(Currency currency, BigDecimal balance, String name, double percentageRate) {
        this.currency = currency;
        this.balance = balance;
        this.initialBalance = this.balance;
        this.name = name;
        this.percentageRate = percentageRate;
    }

    public BigDecimal debtRequest() {
         BigDecimal possibleDebt = initialBalance.subtract(balance);
         if (possibleDebt.signum() > -1) return possibleDebt;
         else return BigDecimal.ZERO;
    }

    public BigDecimal chargePercentage() {
        return debt.multiply(BigDecimal.valueOf(1 + percentageRate));
    }

    @Override
    public void deposit(BigDecimal money) {
        super.deposit(money);
        debt = debtRequest();
    }

    @Override
    public void withdraw(BigDecimal money) throws ArithmeticException {
        super.withdraw(money);
        debt = debtRequest();
    }

    public void setPercentageRate(double percentageRate) {
        this.percentageRate = percentageRate;
    }

    public double getPercentageRate() {
        return percentageRate;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public BigDecimal getDebt() {
        return debt;
    }
}
