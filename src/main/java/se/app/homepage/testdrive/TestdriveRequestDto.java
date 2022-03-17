package se.app.homepage.testdrive;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TestdriveRequestDto {
	
	private Integer request_number;
	
	@NotBlank(message="client_nm은 필수값 입니다.")
//	@Size(min=6,max=6,message="client_nm은 6자리 입니다.") 
	@Pattern(regexp="([A-Z]{4})([0-9]{2})",message="client_nm이 정의된 형식이 아닙니다.")
	private String client_nm;
	
	@NotBlank(message="brand_cd는 필수값 입니다.")
//	@Size(min=1,max=1,message="brand_cd는 1자리 입니다.")
	@Pattern(regexp="(L|T)",message="brand_cd가 정의된 형식이 아닙니다.")
	private String brand_cd;
	
	@NotBlank(message="shop_cd는 필수값 입니다.")
//	@Size(min=7,max=7,message="shop_cd는 7자리 입니다.") 
	@Pattern(regexp="([A-Z]{2})([0-9]{5})",message="shop_cd가 정의된 형식이 아닙니다.")
	private String shop_cd;
	
	@NotBlank(message="model은 필수값 입니다.")
	@Size(min=2,max=50,message="model은 최소2자 최대50자로 전달되야 합니다.")
	private String model;
	
	@NotBlank(message="variant는 필수값 입니다.") 
	@Size(min=3,max=100,message="model은 최소3자 최대100자로 전달되야 합니다.")
	private String variant;
	
	@NotBlank(message="td_input_dt는 필수값 입니다.") 
//	@Size(min=14,max=14,message="td_input_dt는 14자리 입니다.")
	@Pattern(regexp="(20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[0-1])(0[0-9]|1[0-9]|2[0-3])([0-5][0-9])([0-5][0-9])",message="td_input_dt가 유효한 형식이 아닙니다.")
	private String td_input_dt;
	
	@NotBlank(message="td_req_dt는 필수값 입니다.") 
//	@Size(min=8,max=8,message="td_req_dt는 8자리 입니다.")
	@Pattern(regexp="(20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[0-1])",message="td_req_dt가 유효한 형식이 아닙니다.")
	private String td_req_dt;
	
//	@NotBlank(message="td_req_time는 필수값 입니다.")
//	@Size(min=9,max=9,message="td_req_time는 9자리 입니다.")
	@Pattern(regexp="(0[0-9]|1[0-9]|2[0-3])([0-5][0-9])-(0[0-9]|1[0-9]|2[0-3])([0-5][0-9])",message="td_req_time이 유효한 형식이 아닙니다.")
	private String td_req_time;
	
	@NotBlank(message="cust_nm는 필수값 입니다.")
	@Size(min=2,max=50,message="cust_nm는 최소2자 최대50자로 전달되야 합니다.")
	private String cust_nm;
	
	@NotBlank(message="cust_hp는 필수값 입니다.")
//	@Size(min=9,max=11,message="cust_hp는 최소9자 최대11자로 전달되야 합니다.")
	@Pattern(regexp="\\d{2,3}\\d{3,4}\\d{4}",message="cust_hp가 유효한 형식이 아닙니다.")
	private String cust_hp;
	
	@NotBlank(message="visit_area는 필수값 입니다.")
	@Size(min=4,max=100,message="visit_area는 최소4자 최대100자로 전달되야 합니다.")
	private String visit_area;
	
//	@Size(min=1,max=1,message="gender는 1자리 입니다.")
	@Pattern(regexp="(M|W)",message="gender가 유효한 형식이 아닙니다.")
	private String gender; 
	
	@Size(min=3,max=10,message="age는 최소3자 최대10자로 전달되야 합니다.")
	private String age;
	
	@NotBlank(message="email은 필수값 입니다.")
	@Size(min=4,max=100,message="email는 최소4자 최대100자로 전달되야 합니다.")
	private String email;
	
	@NotBlank(message="inbound_path은 필수값 입니다.")
	@Size(min=1,max=50,message="inbound_path는 최소1자 최대50자로 전달되야 합니다.")
	private String inbound_path;
	
	@NotBlank(message="custinfo_exp_dt은 필수값 입니다.")
//	@Size(min=8,max=8,message="custinfo_exp_dt는 8자리 입니다.")
	@Pattern(regexp="(20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[0-1])",message="custinfo_exp_dt가 유효한 형식이 아닙니다.")
	private String custinfo_exp_dt;
	
	@Size(max=500,message="remark는 최대 500자 입니다.")
	private String remark;
	
	private String status_nm;
	
	private String thmp_td_client_id;
	
	private String thmp_td_url;
}
