package com.aludey.sbertest.products.cards;

import com.aludey.sbertest.utils.Currency;

import java.math.BigDecimal;

public class DebitCard extends AbstractCard {

    public DebitCard() {
        this.currency = Currency.RUB;
        this.balance = new BigDecimal("0.0");
        this.name = "Default Debit Card";
    }

    public DebitCard(Currency currency, BigDecimal balance, String name) {
        this.currency = currency;
        this.balance = balance;
        this.name = name;
    }
}
