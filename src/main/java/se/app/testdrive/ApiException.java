package se.app.testdrive;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private ApiStatusEnum error;
	
	public ApiException(ApiStatusEnum e) {
		super(e.getMessage());
		this.error = e;
	}
}
