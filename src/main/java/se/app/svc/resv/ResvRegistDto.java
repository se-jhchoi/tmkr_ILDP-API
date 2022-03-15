package se.app.svc.resv;

public class ResvRegistDto {
	private String lpm_user_no;		
	private String real_resv_date;	
	private String real_resv_st_hm;		
	private String real_resv_end_hm;		
	private String resv_cust_nm;
	private String resv_hp_no;	
	private String resv_stall_no;		
	private String shop_cd;		
	private String svc_type_cd;		
	private String vin;
	private String svc_item_cd;
	private String svc_item_nm;
	private String svc_contents;
	private Integer seq;
	
	public String getLpm_user_no() {
		return lpm_user_no;
	}
	public void setLpm_user_no(String lpm_user_no) {
		this.lpm_user_no = lpm_user_no;
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
	public String getResv_cust_nm() {
		return resv_cust_nm;
	}
	public void setResv_cust_nm(String resv_cust_nm) {
		this.resv_cust_nm = resv_cust_nm;
	}
	public String getResv_hp_no() {
		return resv_hp_no;
	}
	public void setResv_hp_no(String resv_hp_no) {
		this.resv_hp_no = resv_hp_no;
	}
	public String getResv_stall_no() {
		return resv_stall_no;
	}
	public void setResv_stall_no(String resv_stall_no) {
		this.resv_stall_no = resv_stall_no;
	}
	public String getShop_cd() {
		return shop_cd;
	}
	public void setShop_cd(String shop_cd) {
		this.shop_cd = shop_cd;
	}
	public String getSvc_type_cd() {
		return svc_type_cd;
	}
	public void setSvc_type_cd(String svc_type_cd) {
		this.svc_type_cd = svc_type_cd;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getSvc_item_cd() {
		return svc_item_cd;
	}
	public void setSvc_item_cd(String svc_item_cd) {
		this.svc_item_cd = svc_item_cd;
	}
	public String getSvc_item_nm() {
		return svc_item_nm;
	}
	public void setSvc_item_nm(String svc_item_nm) {
		this.svc_item_nm = svc_item_nm;
	}
	public String getSvc_contents() {
		return svc_contents;
	}
	public void setSvc_contents(String svc_contents) {
		this.svc_contents = svc_contents;
	}
}
