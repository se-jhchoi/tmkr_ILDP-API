package se.common;

import org.springframework.validation.Errors;

public class ResponseLogDto {
	private Integer log_seq;
	private String res_data;
	private String res_dt;
	private String sys_log;
	private String upd_dt;
	private String upd_user_id;
	
	public Integer getLog_seq() {
		return log_seq;
	}
	public void setLog_seq(Integer log_seq) {
		this.log_seq = log_seq;
	}
	public String getRes_data() {
		return res_data;
	}
	public void setRes_data(String res_data) {
		this.res_data = res_data;
	}
	public String getRes_dt() {
		return res_dt;
	}
	public void setRes_dt(String res_dt) {
		this.res_dt = res_dt;
	}
	public String getSys_log() {
		return sys_log;
	}
	public void setSys_log(String sys_log) {
		this.sys_log = sys_log;
	}
	public String getUpd_dt() {
		return upd_dt;
	}
	public void setUpd_dt(String upd_dt) {
		this.upd_dt = upd_dt;
	}
	public String getUpd_user_id() {
		return upd_user_id;
	}
	public void setUpd_user_id(String upd_user_id) {
		this.upd_user_id = upd_user_id;
	}
}
