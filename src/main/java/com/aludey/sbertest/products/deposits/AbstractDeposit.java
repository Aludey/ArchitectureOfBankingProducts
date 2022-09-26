package com.aludey.sbertest.products.deposits;

import com.aludey.sbertest.products.AbstractBankProductWithBalance;

public abstract class AbstractDeposit extends AbstractBankProductWithBalance {

    protected String status;

    abstract String getStatus();

    abstract void closeDeposit();
}
