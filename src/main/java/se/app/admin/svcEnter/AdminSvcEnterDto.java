package se.app.admin.svcEnter;

public class AdminSvcEnterDto {
	private int lpm_user_no;
	private String shop_cd;
	private String start_dt;
	private String end_dt;
	private String cust_nm;
	private String svc_type_nm;
	private String propo_stat_nm;
	
	public int getLpm_user_no() {
		return lpm_user_no;
	}
	public void setLpm_user_no(int lpm_user_no) {
		this.lpm_user_no = lpm_user_no;
	}
	public String getShop_cd() {
		return shop_cd;
	}
	public void setShop_cd(String shop_cd) {
		this.shop_cd = shop_cd;
	}
	public String getStart_dt() {
		return start_dt;
	}
	public void setStart_dt(String start_dt) {
		this.start_dt = start_dt;
	}
	public String getEnd_dt() {
		return end_dt;
	}
	public void setEnd_dt(String end_dt) {
		this.end_dt = end_dt;
	}
	public String getCust_nm() {
		return cust_nm;
	}
	public void setCust_nm(String cust_nm) {
		this.cust_nm = cust_nm;
	}
	public String getSvc_type_nm() {
		return svc_type_nm;
	}
	public void setSvc_type_nm(String svc_type_nm) {
		this.svc_type_nm = svc_type_nm;
	}
	public String getPropo_stat_nm() {
		return propo_stat_nm;
	}
	public void setPropo_stat_nm(String propo_stat_nm) {
		this.propo_stat_nm = propo_stat_nm;
	}
}
