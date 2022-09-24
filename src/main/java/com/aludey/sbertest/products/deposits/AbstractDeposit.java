package com.aludey.sbertest.products.deposits;

import com.aludey.sbertest.products.BankProduct;
import com.aludey.sbertest.utils.Currency;

import java.math.BigDecimal;

public abstract class AbstractDeposit implements BankProduct {

    protected Currency currency;

    protected BigDecimal balance;

    protected String name;

    public void deposit(BigDecimal money) {
        this.balance = balance.add(money);
    }

    public BigDecimal balance() {
        return this.balance;
    }
}
