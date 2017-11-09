package cn.jbit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Orderinformation {
	
	public Long orderId;
	public Long productId;
	public Integer quantity;
	public BigDecimal orderAmount;
	public Integer orderStatus;
	public Date orderTime;
	public Date timeofpayment;
	public Date deliverytime;
	public Date receivingtime;
	public Date failuretime;
	public String causeoffailure;
	public Long addressId;
	public String invoiceInformation;
	public Long userId;
	public String distributioncompany;
	public Long trackingNumberCourierNumber;
	public String remark;
	public String paymentMethod;
	public Orderinformation() {
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Date getTimeofpayment() {
		return timeofpayment;
	}
	public void setTimeofpayment(Date timeofpayment) {
		this.timeofpayment = timeofpayment;
	}
	public Date getDeliverytime() {
		return deliverytime;
	}
	public void setDeliverytime(Date deliverytime) {
		this.deliverytime = deliverytime;
	}
	public Date getReceivingtime() {
		return receivingtime;
	}
	public void setReceivingtime(Date receivingtime) {
		this.receivingtime = receivingtime;
	}
	public Date getFailuretime() {
		return failuretime;
	}
	public void setFailuretime(Date failuretime) {
		this.failuretime = failuretime;
	}
	public String getCauseoffailure() {
		return causeoffailure;
	}
	public void setCauseoffailure(String causeoffailure) {
		this.causeoffailure = causeoffailure;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getInvoiceInformation() {
		return invoiceInformation;
	}
	public void setInvoiceInformation(String invoiceInformation) {
		this.invoiceInformation = invoiceInformation;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getDistributioncompany() {
		return distributioncompany;
	}
	public void setDistributioncompany(String distributioncompany) {
		this.distributioncompany = distributioncompany;
	}
	public Long getTrackingNumberCourierNumber() {
		return trackingNumberCourierNumber;
	}
	public void setTrackingNumberCourierNumber(Long trackingNumberCourierNumber) {
		this.trackingNumberCourierNumber = trackingNumberCourierNumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String toString() {
		return "Orderinformation [orderId=" + orderId + ", productId=" + productId + ", quantity="
				+ quantity + ", orderAmount=" + orderAmount + ", orderStatus=" + orderStatus
				+ ", orderTime=" + orderTime + ", timeofpayment=" + timeofpayment
				+ ", deliverytime=" + deliverytime + ", receivingtime=" + receivingtime
				+ ", failuretime=" + failuretime + ", causeoffailure=" + causeoffailure
				+ ", addressId=" + addressId + ", invoiceInformation=" + invoiceInformation
				+ ", userId=" + userId + ", distributioncompany=" + distributioncompany
				+ ", trackingNumberCourierNumber=" + trackingNumberCourierNumber + ", remark="
				+ remark + ", paymentMethod=" + paymentMethod + "]";
	}
	

	
	
}
