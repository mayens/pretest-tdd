package com.priceminister.account.implementation;

import com.priceminister.account.*;

public class CustomerAccount implements Account {

	private double currentBalance = 0.0d;

	public void add(Double addedAmount) {
		// TODO Auto-generated method stub
		currentBalance += addedAmount;
	}

	public Double getBalance() {
		// TODO Auto-generated method stub
		return currentBalance;
	}

	public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) throws IllegalBalanceException {
		Double resultingAccountBalance = -1d;
		if (null != withdrawnAmount && null != rule) {
			resultingAccountBalance = currentBalance - withdrawnAmount;

		}
		if (!rule.withdrawPermitted(resultingAccountBalance)) {
			throw new IllegalBalanceException(resultingAccountBalance);
		}
		return resultingAccountBalance;
	}

}
