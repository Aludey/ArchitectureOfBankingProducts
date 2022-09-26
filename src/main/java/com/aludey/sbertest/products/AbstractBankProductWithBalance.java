package com.aludey.sbertest.products;

import com.aludey.sbertest.utils.Currency;

import java.math.BigDecimal;

public abstract class AbstractBankProductWithBalance implements BankProduct {

    protected Currency currency;

    protected BigDecimal balance;

    protected String name;

    public void deposit(BigDecimal money) {
        balance = balance.add(money);
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
