package com.aludey.sbertest.products.cards;

import com.aludey.sbertest.utils.Currency;

import java.math.BigDecimal;

public class CurrencyDebitCard extends AbstractCard{

    public CurrencyDebitCard() {
        this.currency = Currency.USD;
        this.balance = new BigDecimal("0.0");
        this.name = "Default Currency Debit Card";
    }

    public CurrencyDebitCard(Currency currency, BigDecimal balance, String name) {
        this.currency = currency;
        this.balance = balance;
        this.name = name;
    }
}
