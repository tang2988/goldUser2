package cn.jbit.entity;

import java.util.Date;

public class Withdrawalform {
	
	public Long withdrawalId;
	public Integer rechargeStatus;
	public Long withdrawdMoneny;
	public Date applyfortime;
	public Date succeedtime;
	public Date errortime;
	public Long UserId;
	public Withdrawalform() {
	}
	public Long getWithdrawalId() {
		return withdrawalId;
	}
	public void setWithdrawalId(Long withdrawalId) {
		this.withdrawalId = withdrawalId;
	}
	public Integer getRechargeStatus() {
		return rechargeStatus;
	}
	public void setRechargeStatus(Integer rechargeStatus) {
		this.rechargeStatus = rechargeStatus;
	}
	public Long getWithdrawdMoneny() {
		return withdrawdMoneny;
	}
	public void setWithdrawdMoneny(Long withdrawdMoneny) {
		this.withdrawdMoneny = withdrawdMoneny;
	}
	public Date getApplyfortime() {
		return applyfortime;
	}
	public void setApplyfortime(Date applyfortime) {
		this.applyfortime = applyfortime;
	}
	public Date getSucceedtime() {
		return succeedtime;
	}
	public void setSucceedtime(Date succeedtime) {
		this.succeedtime = succeedtime;
	}
	public Date getErrortime() {
		return errortime;
	}
	public void setErrortime(Date errortime) {
		this.errortime = errortime;
	}
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	@Override
	public String toString() {
		return "Withdrawalform [withdrawalId=" + withdrawalId + ", rechargeStatus="
				+ rechargeStatus + ", withdrawdMoneny=" + withdrawdMoneny + ", applyfortime="
				+ applyfortime + ", succeedtime=" + succeedtime + ", errortime=" + errortime
				+ ", UserId=" + UserId + "]";
	}
	
	
	
	
	

	
	
}
