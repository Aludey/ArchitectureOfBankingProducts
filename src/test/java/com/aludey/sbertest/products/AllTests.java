package com.aludey.sbertest.products;

import com.aludey.sbertest.products.cards.CreditCardTest;
import com.aludey.sbertest.products.cards.CurrencyDebitCardTest;
import com.aludey.sbertest.products.cards.DebitCardTest;
import com.aludey.sbertest.products.deposits.CommonDepositTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CreditCardTest.class, CurrencyDebitCardTest.class, DebitCardTest.class, CommonDepositTest.class})
public class AllTests {

}
