package se.app.svc.odometer;

public class OdometerDto {
	private String vin;
	private String shop_nm;
	private String odometer;
	private String reg_dt;
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getShop_nm() {
		return shop_nm;
	}
	public void setShop_nm(String shop_nm) {
		this.shop_nm = shop_nm;
	}
	public String getOdometer() {
		return odometer;
	}
	public void setOdometer(String odometer) {
		this.odometer = odometer;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
}
