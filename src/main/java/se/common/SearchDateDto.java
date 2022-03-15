package se.common;

public class SearchDateDto {
	private String lpm_user_no;
	private String vin;
	private String start_dt;
	private String end_dt;
	
	public String getLpm_user_no() {
		return lpm_user_no;
	}
	public void setLpm_user_no(String lpm_user_no) {
		this.lpm_user_no = lpm_user_no;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
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
}
