package cn.jbit.entity;

public class Account {
	
	/**
	 * 账户ID
	 */
	public Long accountId;
	/**
	 * 资产总额
	 */
	public Long totalAssets;
	/**
	 * 累计收益
	 */
	public Integer accumulatedIncome;
	public Long  frozenCapital;
	public Long  frostgold;
	public Long  accountbalance;
	public Integer goldgrammage;
	public Integer goldpresentvalue;
	public Integer accountStatusl;
	public Long userId;
	public Account() {
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getTotalAssets() {
		return totalAssets;
	}
	public void setTotalAssets(Long totalAssets) {
		this.totalAssets = totalAssets;
	}
	public Integer getAccumulatedIncome() {
		return accumulatedIncome;
	}
	public void setAccumulatedIncome(Integer accumulatedIncome) {
		this.accumulatedIncome = accumulatedIncome;
	}
	public Long getFrozenCapital() {
		return frozenCapital;
	}
	public void setFrozenCapital(Long frozenCapital) {
		this.frozenCapital = frozenCapital;
	}
	public Long getFrostgold() {
		return frostgold;
	}
	public void setFrostgold(Long frostgold) {
		this.frostgold = frostgold;
	}
	public Long getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(Long accountbalance) {
		this.accountbalance = accountbalance;
	}
	public Integer getGoldgrammage() {
		return goldgrammage;
	}
	public void setGoldgrammage(Integer goldgrammage) {
		this.goldgrammage = goldgrammage;
	}
	public Integer getGoldpresentvalue() {
		return goldpresentvalue;
	}
	public void setGoldpresentvalue(Integer goldpresentvalue) {
		this.goldpresentvalue = goldpresentvalue;
	}
	public Integer getAccountStatusl() {
		return accountStatusl;
	}
	public void setAccountStatusl(Integer accountStatusl) {
		this.accountStatusl = accountStatusl;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", totalAssets=" + totalAssets
				+ ", accumulatedIncome=" + accumulatedIncome + ", frozenCapital=" + frozenCapital
				+ ", frostgold=" + frostgold + ", accountbalance=" + accountbalance
				+ ", goldgrammage=" + goldgrammage + ", goldpresentvalue=" + goldpresentvalue
				+ ", accountStatusl=" + accountStatusl + ", userId=" + userId + "]";
	}

	
	
		
		
	

}
