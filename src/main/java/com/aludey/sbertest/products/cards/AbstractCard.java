package com.aludey.sbertest.products.cards;

import com.aludey.sbertest.products.BankProduct;
import com.aludey.sbertest.utils.Currency;

import java.math.BigDecimal;

public abstract class AbstractCard implements BankProduct {

    protected Currency currency;

    protected BigDecimal balance;

    protected String name;


    public void deposit(BigDecimal money) {
        balance = balance.add(money);
    }

    public void withdraw(BigDecimal money) throws ArithmeticException {
        if (balance.compareTo(money) > -1) balance = balance.subtract(money);
        else throw new ArithmeticException("The balance is less than the requested amount!");
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}
