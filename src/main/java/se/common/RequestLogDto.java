package se.common;

public class RequestLogDto {
	private Integer log_seq;
	private String req_user_id;
	private String req_protocol;
	private String req_contexttype;
	private String req_method;
	private String req_path;
	private String req_data;
	private String req_dt;
	private String reg_dt;
	private String reg_user_id;
	
	public Integer getLog_seq() {
		return log_seq;
	}
	public void setLog_seq(Integer log_seq) {
		this.log_seq = log_seq;
	}
	public String getReq_user_id() {
		return req_user_id;
	}
	public void setReq_user_id(String req_user_id) {
		this.req_user_id = req_user_id;
	}
	public String getReq_protocol() {
		return req_protocol;
	}
	public void setReq_protocol(String req_protocol) {
		this.req_protocol = req_protocol;
	}
	public String getReq_contexttype() {
		return req_contexttype;
	}
	public void setReq_contexttype(String req_contexttype) {
		this.req_contexttype = req_contexttype;
	}
	public String getReq_method() {
		return req_method;
	}
	public void setReq_method(String req_method) {
		this.req_method = req_method;
	}
	public String getReq_path() {
		return req_path;
	}
	public void setReq_path(String req_path) {
		this.req_path = req_path;
	}
	public String getReq_data() {
		return req_data;
	}
	public void setReq_data(String req_data) {
		this.req_data = req_data;
	}
	public String getReq_dt() {
		return req_dt;
	}
	public void setReq_dt(String req_dt) {
		this.req_dt = req_dt;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getReg_user_id() {
		return reg_user_id;
	}
	public void setReg_user_id(String reg_user_id) {
		this.reg_user_id = reg_user_id;
	}
}
