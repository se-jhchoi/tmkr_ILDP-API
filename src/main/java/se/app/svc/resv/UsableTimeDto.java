package se.app.svc.resv;

public class UsableTimeDto {
	private String shop_cd;
	private String resv_date;
	private String resv_date_dateformat;
	
	public String getShop_cd() {
		return shop_cd;
	}
	public void setShop_cd(String shop_cd) {
		this.shop_cd = shop_cd;
	}
	public String getResv_date() {
		return resv_date;
	}
	public void setResv_date(String resv_date) {
		this.resv_date = resv_date;
	}
	public String getResv_date_dateformat() {
		return resv_date_dateformat;
	}
	public void setResv_date_dateformat(String resv_date_dateformat) {
		this.resv_date_dateformat = resv_date_dateformat;
	}
}
