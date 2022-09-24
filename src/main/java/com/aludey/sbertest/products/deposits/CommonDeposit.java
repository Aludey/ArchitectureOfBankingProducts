package com.aludey.sbertest.products.deposits;

import com.aludey.sbertest.utils.Currency;

import java.math.BigDecimal;

public class CommonDeposit extends AbstractDeposit {

    private String status;

    public CommonDeposit() {
        this.currency = Currency.EUR;
        this.balance = new BigDecimal("1000.0");
        this.name = "Default Common Deposit";
        this.status = "Active";
    }

    public CommonDeposit(Currency currency, BigDecimal balance, String name) {
        this.currency = currency;
        this.balance = balance;
        this.name = name;
        this.status = "Active";
    }

    public void closeDeposit() {
        this.balance = BigDecimal.ZERO;
        this.status = "Closed";
    }
}
