package cn.jbit.entity;

import java.util.Date;

public class Topuprecharge {
	
	public Long rechargeId;
	public Long UserId;
	public Integer recharmoney;
	public  Date rechargeTime;
	public Integer rechargeStatus;
	public Date succeedTime;
	public Date errorTime;
	public Long banklistId;
	
	public Topuprecharge() {
	}
	public Long getRechargeId() {
		return rechargeId;
	}
	public void setRechargeId(Long rechargeId) {
		this.rechargeId = rechargeId;
	}
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public Integer getRecharmoney() {
		return recharmoney;
	}
	public void setRecharmoney(Integer recharmoney) {
		this.recharmoney = recharmoney;
	}
	public Date getRechargeTime() {
		return rechargeTime;
	}
	public void setRechargeTime(Date rechargeTime) {
		this.rechargeTime = rechargeTime;
	}
	public Integer getRechargeStatus() {
		return rechargeStatus;
	}
	public void setRechargeStatus(Integer rechargeStatus) {
		this.rechargeStatus = rechargeStatus;
	}
	public Date getSucceedTime() {
		return succeedTime;
	}
	public void setSucceedTime(Date succeedTime) {
		this.succeedTime = succeedTime;
	}
	public Date getErrorTime() {
		return errorTime;
	}
	public void setErrorTime(Date errorTime) {
		this.errorTime = errorTime;
	}
	
	
	public Long getBanklistId() {
		return banklistId;
	}
	public void setBanklistId(Long banklistId) {
		this.banklistId = banklistId;
	}
	@Override
	public String toString() {
		return "Topuprecharge [rechargeId=" + rechargeId + ", UserId=" + UserId + ", recharmoney="
				+ recharmoney + ", rechargeTime=" + rechargeTime + ", rechargeStatus="
				+ rechargeStatus + ", succeedTime=" + succeedTime + ", errorTime=" + errorTime
				+ "]";
	}
	

	

	
	

}
