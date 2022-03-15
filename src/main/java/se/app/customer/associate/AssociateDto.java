package se.app.customer.associate;

public class AssociateDto {
	private String dlr_contract_no;
    private String cust_nm;
    private String hp_no;
    private String search_type;
    
	public String getDlr_contract_no() {
		return dlr_contract_no;
	}
	public void setDlr_contract_no(String dlr_contract_no) {
		this.dlr_contract_no = dlr_contract_no;
	}
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
	public String getSearch_type() {
		return search_type;
	}
	public void setSearch_type(String search_type) {
		this.search_type = search_type;
	}
}
