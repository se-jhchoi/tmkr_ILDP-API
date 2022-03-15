package se.app.svc.resv;

public class CenterResvDto {
	private String shop_cd;
	private String resv_seq;
	private String real_resv_date;
	private String real_resv_st_hm;
	private String real_resv_end_hm;
	private String resv_stall_no;
	
	public String getShop_cd() {
		return shop_cd;
	}
	public void setShop_cd(String shop_cd) {
		this.shop_cd = shop_cd;
	}
	public String getResv_seq() {
		return resv_seq;
	}
	public void setResv_seq(String resv_seq) {
		this.resv_seq = resv_seq;
	}
	public String getReal_resv_date() {
		return real_resv_date;
	}
	public void setReal_resv_date(String real_resv_date) {
		this.real_resv_date = real_resv_date;
	}
	public String getReal_resv_st_hm() {
		return real_resv_st_hm;
	}
	public void setReal_resv_st_hm(String real_resv_st_hm) {
		this.real_resv_st_hm = real_resv_st_hm;
	}
	public String getReal_resv_end_hm() {
		return real_resv_end_hm;
	}
	public void setReal_resv_end_hm(String real_resv_end_hm) {
		this.real_resv_end_hm = real_resv_end_hm;
	}
	public String getResv_stall_no() {
		return resv_stall_no;
	}
	public void setResv_stall_no(String resv_stall_no) {
		this.resv_stall_no = resv_stall_no;
	}
}
