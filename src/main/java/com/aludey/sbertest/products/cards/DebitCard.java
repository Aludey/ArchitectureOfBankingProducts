package com.aludey.sbertest.products.cards;

import com.aludey.sbertest.utils.Currency;

import java.math.BigDecimal;

public class DebitCard extends AbstractCard {

    public DebitCard(BigDecimal balance, String name) {
        this.currency = Currency.RUB;
        this.balance = balance;
        this.name = name;
    }
}
