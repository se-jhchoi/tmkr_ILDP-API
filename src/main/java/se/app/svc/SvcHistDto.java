package se.app.svc;

public class SvcHistDto {
	private String svc_nm;
	private String shop_nm;
	private String propo_dt;
	private String propo_seq;
	private String file_url;
	
	public String getSvc_nm() {
		return svc_nm;
	}
	public void setSvc_nm(String svc_nm) {
		this.svc_nm = svc_nm;
	}
	public String getShop_nm() {
		return shop_nm;
	}
	public void setShop_nm(String shop_nm) {
		this.shop_nm = shop_nm;
	}
	public String getPropo_dt() {
		return propo_dt;
	}
	public void setPropo_dt(String propo_dt) {
		this.propo_dt = propo_dt;
	}
	public String getPropo_seq() {
		return propo_seq;
	}
	public void setPropo_seq(String propo_seq) {
		this.propo_seq = propo_seq;
	}
	public String getFile_url() {
		return file_url;
	}
	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}
}
