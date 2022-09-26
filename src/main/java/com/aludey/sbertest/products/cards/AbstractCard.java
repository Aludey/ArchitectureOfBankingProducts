package com.aludey.sbertest.products.cards;

import com.aludey.sbertest.products.AbstractBankProductWithBalance;

import java.math.BigDecimal;

public abstract class AbstractCard extends AbstractBankProductWithBalance {

    public void withdraw(BigDecimal money) throws ArithmeticException {
        if (balance.compareTo(money) > -1) balance = balance.subtract(money);
        else throw new ArithmeticException("The balance is less than the requested amount!");
    }
}
