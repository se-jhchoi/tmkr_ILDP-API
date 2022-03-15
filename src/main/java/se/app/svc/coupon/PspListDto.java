package se.app.svc.coupon;

public class PspListDto {
	private String vin;
	
	private String psp_item_nm;
	private String apply_st_date;
	private String apply_end_date;
	private String exec_shop_nm;
	private String exec_yn;
	private String exec_date;
	private String can_use_yn;
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	
	public String getPsp_item_nm() {
		return psp_item_nm;
	}
	public void setPsp_item_nm(String psp_item_nm) {
		this.psp_item_nm = psp_item_nm;
	}
	public String getApply_st_date() {
		return apply_st_date;
	}
	public void setApply_st_date(String apply_st_date) {
		this.apply_st_date = apply_st_date;
	}
	public String getApply_end_date() {
		return apply_end_date;
	}
	public void setApply_end_date(String apply_end_date) {
		this.apply_end_date = apply_end_date;
	}
	public String getExec_shop_nm() {
		return exec_shop_nm;
	}
	public void setExec_shop_nm(String exec_shop_nm) {
		this.exec_shop_nm = exec_shop_nm;
	}
	public String getExec_yn() {
		return exec_yn;
	}
	public void setExec_yn(String exec_yn) {
		this.exec_yn = exec_yn;
	}
	public String getExec_date() {
		return exec_date;
	}
	public void setExec_date(String exec_date) {
		this.exec_date = exec_date;
	}
	public String getCan_use_yn() {
		return can_use_yn;
	}
	public void setCan_use_yn(String can_use_yn) {
		this.can_use_yn = can_use_yn;
	}
	
	
}
