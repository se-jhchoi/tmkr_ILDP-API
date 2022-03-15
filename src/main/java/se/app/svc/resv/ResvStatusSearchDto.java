package se.app.svc.resv;

public class ResvStatusSearchDto {
	private String vin;
	private String shop_cd;
	private String resv_dt;
	private String resv_seq;
	private String stat_cd;
	private String stat_nm;
	
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
	public String getStat_cd() {
		return stat_cd;
	}
	public void setStat_cd(String stat_cd) {
		this.stat_cd = stat_cd;
	}
	public String getStat_nm() {
		return stat_nm;
	}
	public void setStat_nm(String stat_nm) {
		this.stat_nm = stat_nm;
	}

	
}
