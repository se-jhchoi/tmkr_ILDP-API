package se.app.customer.active;

import java.util.Map;

public class CustomerActiveDto {
	private String lpm_user_no;
	private String active_cd;
	private Map<String, String> active_data;
	private String active_contents;
	private String up_lpm_user_no;
	private String up_dealer_id;
	
	public String getLpm_user_no() {
		return lpm_user_no;
	}
	public void setLpm_user_no(String lpm_user_no) {
		this.lpm_user_no = lpm_user_no;
	}
	public String getActive_cd() {
		return active_cd;
	}
	public void setActive_cd(String active_cd) {
		this.active_cd = active_cd;
	}
	public Map<String, String> getActive_data() {
		return active_data;
	}
	public void setActive_data(Map<String, String> active_data) {
		this.active_data = active_data;
	}
	public String getActive_contents() {
		return active_contents;
	}
	public void setActive_contents(String active_contents) {
		this.active_contents = active_contents;
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
