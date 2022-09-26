package com.aludey.sbertest.products.deposits;

import com.aludey.sbertest.products.AbstractBankProductWithBalance;

import java.math.BigDecimal;

public abstract class AbstractDeposit extends AbstractBankProductWithBalance {

    protected String status;

    public String getStatus() {
        return status;
    }

    public void closeDeposit() throws IllegalStateException {
        if (!getStatus().equals("Closed")) {
            this.balance = BigDecimal.ZERO;
            this.status = "Closed";
        } else throw new IllegalStateException("Deposit is already closed!");
    }
}
