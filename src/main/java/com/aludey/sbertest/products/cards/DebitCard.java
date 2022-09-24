package com.aludey.sbertest.products.cards;

import com.aludey.sbertest.utils.Currency;

import java.math.BigDecimal;

public class DebitCard extends AbstractCard {

    public DebitCard() {
        currency = Currency.RUB;
        balance = new BigDecimal("0.0");
        name = "Default Debit Card";
    }

    public DebitCard(BigDecimal balance, String name) {
        this.currency = Currency.RUB;
        this.balance = balance;
        this.name = name;
    }
}
