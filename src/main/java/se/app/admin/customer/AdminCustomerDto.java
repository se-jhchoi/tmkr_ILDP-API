package se.app.admin.customer;

public class AdminCustomerDto {
	private int lpm_user_no;
	private String cust_nm;
	private String hp;
	private String vin;
	private String last_retail_sales_dt;
	private String group_name;
	
	public int getLpm_user_no() {
		return lpm_user_no;
	}
	public void setLpm_user_no(int lpm_user_no) {
		this.lpm_user_no = lpm_user_no;
	}
	public String getCust_nm() {
		return cust_nm;
	}
	public void setCust_nm(String cust_nm) {
		this.cust_nm = cust_nm;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getLast_retail_sales_dt() {
		return last_retail_sales_dt;
	}
	public void setLast_retail_sales_dt(String last_retail_sales_dt) {
		this.last_retail_sales_dt = last_retail_sales_dt;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
}
