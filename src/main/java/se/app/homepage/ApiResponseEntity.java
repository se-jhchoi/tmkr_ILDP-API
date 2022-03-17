package se.app.homepage;

import lombok.Builder;
import lombok.Data;

@Data
public class ApiResponseEntity {
	private String code;
	private String message;
	private Object data;

	@Builder
	public ApiResponseEntity(String code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
}
