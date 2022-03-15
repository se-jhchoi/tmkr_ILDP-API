package se.app.customer.joint;

public class JointRemoveDto {
	private String lpm_user_no;
	private String up_lpm_user_no;
	private String up_dealer_id;
	
	public String getLpm_user_no() {
		return lpm_user_no;
	}
	public void setLpm_user_no(String lpm_user_no) {
		this.lpm_user_no = lpm_user_no;
	}
	public String getUp_lpm_user_no() {
		return up_lpm_user_no;
	}
	public void setUp_lpm_user_no(String up_lpm_user_no) {
		this.up_lpm_user_no = up_lpm_user_no;
	}
	public String getUp_dealer_id() {
		return up_dealer_id;
	}
	public void setUp_dealer_id(String up_dealer_id) {
		this.up_dealer_id = up_dealer_id;
	}
}
