package se.app.contract;

public class ContractDto {
	private Integer contract_no;
	private Integer cust_seq;
	private Integer comp_seq;
	private String vin;
	private String contract_stat_cd;
	private String contract_cd;
	private String dlvy_yn;
	
	public Integer getContract_no() {
		return contract_no;
	}
	public void setContract_no(Integer contract_no) {
		this.contract_no = contract_no;
	}
	public Integer getCust_seq() {
		return cust_seq;
	}
	public void setCust_seq(Integer cust_seq) {
		this.cust_seq = cust_seq;
	}
	public Integer getComp_seq() {
		return comp_seq;
	}
	public void setComp_seq(Integer comp_seq) {
		this.comp_seq = comp_seq;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getContract_stat_cd() {
		return contract_stat_cd;
	}
	public void setContract_stat_cd(String contract_stat_cd) {
		this.contract_stat_cd = contract_stat_cd;
	}
	public String getContract_cd() {
		return contract_cd;
	}
	public void setContract_cd(String contract_cd) {
		this.contract_cd = contract_cd;
	}
	public String getDlvy_yn() {
		return dlvy_yn;
	}
	public void setDlvy_yn(String dlvy_yn) {
		this.dlvy_yn = dlvy_yn;
	}
}
