package se.app.customer.regular;

public class RegularRegistDto {
	private String cust_nm;
	private String hp_no;
	private String lpm_user_no;
    private String lpm_reg_dt;
    private String vin;
    private String dlr_contract_no;
    private String pass_key;
    
	public String getCust_nm() {
		return cust_nm;
	}
	public void setCust_nm(String cust_nm) {
		this.cust_nm = cust_nm;
	}
	public String getHp_no() {
		return hp_no;
	}
	public void setHp_no(String hp_no) {
		this.hp_no = hp_no;
	}
	public String getLpm_user_no() {
		return lpm_user_no;
	}
	public void setLpm_user_no(String lpm_user_no) {
		this.lpm_user_no = lpm_user_no;
	}
	public String getLpm_reg_dt() {
		return lpm_reg_dt;
	}
	public void setLpm_reg_dt(String lpm_reg_dt) {
		this.lpm_reg_dt = lpm_reg_dt;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getDlr_contract_no() {
		return dlr_contract_no;
	}
	public void setDlr_contract_no(String dlr_contract_no) {
		this.dlr_contract_no = dlr_contract_no;
	}
	public String getPass_key() {
		return pass_key;
	}
	public void setPass_key(String pass_key) {
		this.pass_key = pass_key;
	}
}
