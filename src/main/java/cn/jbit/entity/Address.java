package cn.jbit.entity;

public class Address {
	
	public Long addressId;
	public String userName;
	public String mobilePhone;
	public Long userId;
	public String twelveProvincesAndcities;
	public String detailedAddressStreet;
	public Address() {
	}
	
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String t_address() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getTwelveProvincesAndcities() {
		return twelveProvincesAndcities;
	}
	public void setTwelveProvincesAndcities(String twelveProvincesAndcities) {
		this.twelveProvincesAndcities = twelveProvincesAndcities;
	}
	public String getDetailedAddressStreet() {
		return detailedAddressStreet;
	}
	public void setDetailedAddressStreet(String detailedAddressStreet) {
		this.detailedAddressStreet = detailedAddressStreet;
	}
	
	public String toString() {
		return "Address [addressId=" + addressId + ", userName=" + userName + ", mobilePhone="
				+ mobilePhone + ", userId=" + userId + ", twelveProvincesAndcities="
				+ twelveProvincesAndcities + ", detailedAddressStreet=" + detailedAddressStreet
				+ "]";
	}

	public String getMobilePhone() {
		return mobilePhone;
	}
	
	

}
