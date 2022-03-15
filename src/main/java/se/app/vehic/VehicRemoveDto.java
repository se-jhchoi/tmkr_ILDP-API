package se.app.vehic;

public class VehicRemoveDto {
	private String lpm_user_no;
	private String vin;
	private String remove_reason_cd;
	private String remove_reason;
	
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
	public String getRemove_reason_cd() {
		return remove_reason_cd;
	}
	public void setRemove_reason_cd(String remove_reason_cd) {
		this.remove_reason_cd = remove_reason_cd;
	}
	public String getRemove_reason() {
		return remove_reason;
	}
	public void setRemove_reason(String remove_reason) {
		this.remove_reason = remove_reason;
	}
}
