package se.app.customer.regular;

public class RegularResultDto {
	private Integer	cust_seq;
	private String certify_yn;
	private String certify_dt;
	
	public Integer getCust_seq() {
		return cust_seq;
	}
	public void setCust_seq(Integer cust_seq) {
		this.cust_seq = cust_seq;
	}
	public String getCertify_yn() {
		return certify_yn;
	}
	public void setCertify_yn(String certi_yn) {
		this.certify_yn = certi_yn;
	}
	public String getCertify_dt() {
		return certify_dt;
	}
	public void setCertify_dt(String certify_dt) {
		this.certify_dt = certify_dt;
	}
}
