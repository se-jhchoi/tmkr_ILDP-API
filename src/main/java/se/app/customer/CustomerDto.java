package se.app.customer;

public class CustomerDto {
	private Integer cust_seq;
    private String cust_nm;
    private String hp_area;
    private String hp_no;
    private String full_hp_no;
    
	public Integer getCust_seq() {
		return cust_seq;
	}
	public void setCust_seq(Integer cust_seq) {
		this.cust_seq = cust_seq;
	}
	public String getCust_nm() {
		return cust_nm;
	}
	public void setCust_nm(String cust_nm) {
		this.cust_nm = cust_nm;
	}
	public String getHp_area() {
		return hp_area;
	}
	public void setHp_area(String hp_area) {
		this.hp_area = hp_area;
	}
	public String getHp_no() {
		return hp_no;
	}
	public void setHp_no(String hp_no) {
		this.hp_no = hp_no;
	}
	public String getFull_hp_no() {
		return full_hp_no;
	}
	public void setFull_hp_no(String full_hp_no) {
		this.full_hp_no = full_hp_no;
	}
}
