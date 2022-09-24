package com.aludey.sbertest.products.cards;

import com.aludey.sbertest.products.BankProduct;
import com.aludey.sbertest.utils.Currency;

import java.math.BigDecimal;

public abstract class AbstractCard implements BankProduct {

    protected Currency currency;

    protected BigDecimal balance;

    protected String name;


    public void deposit(BigDecimal money) {
        this.balance = balance.add(money);
    }

    public void withdraw(BigDecimal money){
        this.balance = balance.subtract(money);
    }

    public BigDecimal balance() {
        return this.balance;
    }
}
