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

    public void withdraw(BigDecimal money) {
        balance = balance.subtract(money);
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
