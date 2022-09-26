package com.aludey.sbertest.products.deposits;

import com.aludey.sbertest.utils.Currency;

import java.math.BigDecimal;

public class CommonDeposit extends AbstractDeposit {

    public CommonDeposit(Currency currency, BigDecimal balance, String name) {
        this.currency = currency;
        this.balance = balance;
        this.name = name;
        this.status = "Active";
    }
}
