package cn.jbit.entity;

import java.math.BigDecimal;

public class Account {
	
	

	/**
	 * 账户ID
	 */
	public Long accountId;
	/**
	 * 资产总额
	 */
	public BigDecimal totalAssets;
	/**
	 * 累计收益
	 */
	public BigDecimal accumulatedIncome;
	public BigDecimal  frozenCapital;
	public BigDecimal  frostgold;
	public BigDecimal  accountbalance;
	public BigDecimal goldgrammage;
	public BigDecimal goldpresentvalue;
	public Integer accountStatus;
	public Long userId;
	public Account() {
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public BigDecimal getTotalAssets() {
		return totalAssets;
	}
	public void setTotalAssets(BigDecimal totalAssets) {
		this.totalAssets = totalAssets;
	}
	public BigDecimal getAccumulatedIncome() {
		return accumulatedIncome;
	}
	public void setAccumulatedIncome(BigDecimal accumulatedIncome) {
		this.accumulatedIncome = accumulatedIncome;
	}
	public BigDecimal getFrozenCapital() {
		return frozenCapital;
	}
	public void setFrozenCapital(BigDecimal frozenCapital) {
		this.frozenCapital = frozenCapital;
	}
	public BigDecimal getFrostgold() {
		return frostgold;
	}
	public void setFrostgold(BigDecimal frostgold) {
		this.frostgold = frostgold;
	}
	public BigDecimal getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(BigDecimal accountbalance) {
		this.accountbalance = accountbalance;
	}
	public BigDecimal getGoldgrammage() {
		return goldgrammage;
	}
	public void setGoldgrammage(BigDecimal goldgrammage) {
		this.goldgrammage = goldgrammage;
	}
	public BigDecimal getGoldpresentvalue() {
		return goldpresentvalue;
	}
	public void setGoldpresentvalue(BigDecimal goldpresentvalue) {
		this.goldpresentvalue = goldpresentvalue;
	}
	public Integer getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String toString() {
		return "Account [accountId=" + accountId + ", totalAssets=" + totalAssets
				+ ", accumulatedIncome=" + accumulatedIncome + ", frozenCapital=" + frozenCapital
				+ ", frostgold=" + frostgold + ", accountbalance=" + accountbalance
				+ ", goldgrammage=" + goldgrammage + ", goldpresentvalue=" + goldpresentvalue
				+ ", accountStatus=" + accountStatus + ", userId=" + userId + "]";
	}
	
	
}
	