package se.app.svc.resv;

public class RemindReactionDto {
	private String vin;
	private String shop_cd;
	private String resv_dt;
	private String resv_seq;
	private String remind_reaction;
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getShop_cd() {
		return shop_cd;
	}
	public void setShop_cd(String shop_cd) {
		this.shop_cd = shop_cd;
	}
	public String getResv_dt() {
		return resv_dt;
	}
	public void setResv_dt(String resv_dt) {
		this.resv_dt = resv_dt;
	}
	public String getResv_seq() {
		return resv_seq;
	}
	public void setResv_seq(String resv_seq) {
		this.resv_seq = resv_seq;
	}
	public String getRemind_reaction() {
		return remind_reaction;
	}
	public void setRemind_reaction(String remind_reaction) {
		this.remind_reaction = remind_reaction;
	}
}
