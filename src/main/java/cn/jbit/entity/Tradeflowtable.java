package cn.jbit.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Tradeflowtable {
	
	public Long transactionId;
	public Long businessId;
	public String businessdescription;
	public BigDecimal money;
	public Integer type;
	public Integer businesstype;
	public String remark;
	public Integer versionNo;
	public Date createTime;
	public Tradeflowtable() {
	}
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public Long getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}
	public String getBusinessdescription() {
		return businessdescription;
	}
	public void setBusinessdescription(String businessdescription) {
		this.businessdescription = businessdescription;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getBusinesstype() {
		return businesstype;
	}
	public void setBusinesstype(Integer businesstype) {
		this.businesstype = businesstype;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String toString() {
		return "Tradeflowtable [transactionId=" + transactionId
				+ ", businessId=" + businessId + ", businessdescription="
				+ businessdescription + ", money=" + money + ", type=" + type
				+ ", businesstype=" + businesstype + ", remark=" + remark
				+ ", versionNo=" + versionNo + ", createTime=" + createTime
				+ "]";
	}
	
	
	
}
