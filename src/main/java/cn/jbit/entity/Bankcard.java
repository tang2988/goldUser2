package cn.jbit.entity;

public class Bankcard {
	
	public Long bankcardId;
	public Integer bankcardStatus;
	public String BanknameId;
	public Long card;
	public Long UserId;
	public Bankcard() {
	}
	public Long getBankcardId() {
		return bankcardId;
	}
	public void setBankcardId(Long bankcardId) {
		this.bankcardId = bankcardId;
	}
	public Integer getBankcardStatus() {
		return bankcardStatus;
	}
	public void setBankcardStatus(Integer bankcardStatus) {
		this.bankcardStatus = bankcardStatus;
	}
	public String getBanknameId() {
		return BanknameId;
	}
	public void setBanknameId(String banknameId) {
		BanknameId = banknameId;
	}
	public Long getCard() {
		return card;
	}
	public void setCard(Long card) {
		this.card = card;
	}
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	@Override
	public String toString() {
		return "Bankcard [bankcardId=" + bankcardId + ", bankcardStatus=" + bankcardStatus
				+ ", BanknameId=" + BanknameId + ", card=" + card + ", UserId=" + UserId + "]";
	}
	
	
	
	
	

}
