package cn.jbit.entity;

public class Banklist {
	public Long banklistId;
	public String bankname;
	public String onlinebanking;
	public String imageUrl;
	public Integer banklistStatus;

	public Banklist() {
	}

	public Long getBanklistId() {
		return banklistId;
	}

	public void setBanklistId(Long banklistId) {
		this.banklistId = banklistId;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getOnlinebanking() {
		return onlinebanking;
	}

	public void setOnlinebanking(String onlinebanking) {
		this.onlinebanking = onlinebanking;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getBanklistStatus() {
		return banklistStatus;
	}

	public void setBanklistStatus(Integer banklistStatus) {
		this.banklistStatus = banklistStatus;
	}

	@Override
	public String toString() {
		return "Banklist [banklistId=" + banklistId + ", bankname=" + bankname
				+ ", onlinebanking=" + onlinebanking + ", imageUrl=" + imageUrl
				+ ", banklistStatus=" + banklistStatus + "]";
	}

}
