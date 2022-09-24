package com.aludey.sbertest.products.cards;

import com.aludey.sbertest.utils.Currency;

import java.math.BigDecimal;

public class CreditCard extends AbstractCard {

    private double percentageRate;

    private final BigDecimal initialBalance;

    private BigDecimal debt = BigDecimal.ZERO;

    public CreditCard(Currency currency, BigDecimal balance, String name, double percentageRate) {
        this.currency = currency;
        this.balance = balance;
        this.initialBalance = this.balance;
        this.name = name;
        this.percentageRate = percentageRate;
    }

    public BigDecimal debtRequest() {
        BigDecimal possibleDebt = initialBalance.subtract(balance);
        if (possibleDebt.signum() > -1) return debt = possibleDebt;
        else return debt = BigDecimal.ZERO;
    }

    public BigDecimal chargePercentage() {
        return debt = debtRequest().multiply(BigDecimal.valueOf(1 + percentageRate));
    }

    @Override
    public void deposit(BigDecimal money) {
        super.deposit(money);
        debtRequest();
    }

    @Override
    public void withdraw(BigDecimal money) throws ArithmeticException {
        super.withdraw(money);
        debtRequest();
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
