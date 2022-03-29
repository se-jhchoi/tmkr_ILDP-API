package se.app.homepage.usedcar;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UsedcarFMCRequestDto {

    private Integer request_number;

    @NotBlank(message="client_nm은 필수값 입니다.")
//	@Size(min=6,max=6,message="client_nm은 6자리 입니다.")
    @Pattern(regexp="([A-Z]{4})([0-9]{2})",message="client_nm이 정의된 형식이 아닙니다.")
    private String client_nm;

    @NotBlank(message="brand_cd는 필수값 입니다.")
    @Pattern(regexp="(L|T)",message="brand_cd가 정의된 형식이 아닙니다.")
    private String brand_cd;

    @NotBlank(message="shop_cd는 필수값 입니다.")
    @Pattern(regexp="([A-Z]{2})([0-9]{5})",message="shop_cd가 정의된 형식이 아닙니다.")
    private String shop_cd;

    private String model;

    @NotBlank(message="variant는 필수값 입니다.")
    @Size(min=3,max=100,message="model은 최소3자 최대100자로 전달되야 합니다.")
    private String variant;

    @NotBlank(message="fmc_input_dt는 필수값 입니다.")
    @Pattern(regexp="(20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[0-1])(0[0-9]|1[0-9]|2[0-3])([0-5][0-9])([0-5][0-9])",message="fmc_input_dt가 유효한 형식이 아닙니다.")
    private String fmc_input_dt;

    @NotBlank(message="fmc_req_dt는 필수값 입니다.")
    @Pattern(regexp="(20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[0-1])-((20)\\d{2}|(9999))(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[0-1])",message="fmc_req_dt가 유효한 형식이 아닙니다.")
    private String fmc_req_dt;

    @NotBlank(message="plate_no는 필수값 입니다.")
    @Pattern(regexp="\\d{2,3}[가-힣]{1}\\d{4}",message="plate_no가 유효한 형식이 아닙니다.")
    private String plate_no;

    @NotBlank(message="cust_nm는 필수값 입니다.")
    @Size(min=2,max=50,message="cust_nm는 최소2자 최대50자로 전달되야 합니다.")
    private String cust_nm;

    @NotBlank(message="cust_hp는 필수값 입니다.")
//	@Size(min=9,max=11,message="cust_hp는 최소9자 최대11자로 전달되야 합니다.")
    @Pattern(regexp="\\d{2,3}\\d{3,4}\\d{4}",message="cust_hp가 유효한 형식이 아닙니다.")
    private String cust_hp;

    @NotBlank(message="request_path 필수값 입니다.")
    @Size(min=1,max=500,message="request_path 최소1자 최대500자로 전달되야 합니다.")
    private String request_path;

    @NotBlank(message="inbound_path은 필수값 입니다.")
    @Size(min=1,max=50,message="inbound_path는 최소1자 최대100자로 전달되야 합니다.")
    private String inbound_path;

    @NotBlank(message="custinfo_exp_dt은 필수값 입니다.")
    @Pattern(regexp="(20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[0-1])",message="custinfo_exp_dt가 유효한 형식이 아닙니다.")
    private String custinfo_exp_dt;

    @Size(max=500,message="remark는 최대 500자 입니다.")
    private String remark;


}
