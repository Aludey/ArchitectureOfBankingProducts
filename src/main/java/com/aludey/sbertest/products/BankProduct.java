package com.aludey.sbertest.products;

import java.math.BigDecimal;

public interface BankProduct {

    void deposit(BigDecimal money);

    BigDecimal getBalance();
}
