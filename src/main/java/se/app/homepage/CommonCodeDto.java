package se.app.homepage;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class CommonCodeDto {
	
	@NotBlank(message="brand_cd는 필수값 입니다.")
//	@Size(min=1,max=1,message="brand_cd는 1자리 입니다.")
	@Pattern(regexp="(L|T)",message="brand_cd가 정의된 형식이 아닙니다.")
	private String brand_cd;
	
	@NotBlank(message="code_type는 필수값 입니다.")
	private String code_type;
	private String code;
	private String name;
}
