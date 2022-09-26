package com.aludey.sbertest.products.cards;

import com.aludey.sbertest.utils.Currency;

import java.math.BigDecimal;

public class CurrencyDebitCard extends AbstractCard {

    public CurrencyDebitCard(Currency currency, BigDecimal balance, String name) {
        this.currency = currency;
        this.balance = balance;
        this.name = name;
    }
}
