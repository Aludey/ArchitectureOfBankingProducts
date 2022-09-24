package com.aludey.sbertest.products.cards;

import com.aludey.sbertest.utils.Currency;

import java.math.BigDecimal;

public class CreditCard extends AbstractCard {

    private double percentageRate;

    private final BigDecimal initialBalance;

    private BigDecimal debt = null;


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
        if (debt != null) return debt;
        else {
            debt = initialBalance.subtract(this.balance);
            if (debt.signum() > -1) return debt;
            else return debt = BigDecimal.ZERO;
        }
    }

    public BigDecimal chargePercentage() {
        return debt.multiply(BigDecimal.valueOf(1 + percentageRate));
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
