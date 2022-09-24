package com.aludey.sbertest.utils;

public enum Currency {
    USD("USD"),
    RUB("RUB"),
    EUR("EUR");

    private String title;

    Currency(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
