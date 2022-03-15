package se.app.customer.userInfoAgree;

public class UserInfoAgreeDto {
	private String lpm_user_no;
	private String agree_type;
	private String agree_st_dt;
	private String agree_end_dt;
	
	public String getLpm_user_no() {
		return lpm_user_no;
	}
	public void setLpm_user_no(String lpm_user_no) {
		this.lpm_user_no = lpm_user_no;
	}
	public String getAgree_type() {
		return agree_type;
	}
	public void setAgree_type(String agree_type) {
		this.agree_type = agree_type;
	}
	public String getAgree_st_dt() {
		return agree_st_dt;
	}
	public void setAgree_st_dt(String agree_st_dt) {
		this.agree_st_dt = agree_st_dt;
	}
	public String getAgree_end_dt() {
		return agree_end_dt;
	}
	public void setAgree_end_dt(String agree_end_dt) {
		this.agree_end_dt = agree_end_dt;
	}
}
