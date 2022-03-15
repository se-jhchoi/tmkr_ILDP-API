package se.app.svc.schedule;

public class ScheduleDto {
	private String vin;
	private String shop_cd;
	private String shop_nm;
	private String svc_in_dt;
	private String type_nm;
	private String svc_type_nm;
	private String addr;
	private String tel_no;
	private String mng_sa_nm;
	
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
	public String getShop_nm() {
		return shop_nm;
	}
	public void setShop_nm(String shop_nm) {
		this.shop_nm = shop_nm;
	}
	public String getSvc_in_dt() {
		return svc_in_dt;
	}
	public void setSvc_in_dt(String svc_in_dt) {
		this.svc_in_dt = svc_in_dt;
	}
	public String getType_nm() {
		return type_nm;
	}
	public void setType_nm(String type_nm) {
		this.type_nm = type_nm;
	}
	public String getSvc_type_nm() {
		return svc_type_nm;
	}
	public void setSvc_type_nm(String svc_type_nm) {
		this.svc_type_nm = svc_type_nm;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel_no() {
		return tel_no;
	}
	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}
	public String getMng_sa_nm() {
		return mng_sa_nm;
	}
	public void setMng_sa_nm(String mng_sa_nm) {
		this.mng_sa_nm = mng_sa_nm;
	}
}
