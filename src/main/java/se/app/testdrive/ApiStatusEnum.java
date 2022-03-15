package se.app.testdrive;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ApiStatusEnum {
	
	SUCCESS(HttpStatus.OK,"S01","success"),
	
	ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "R02"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "R03"),
	
	VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "U01","요청값 유효성 검증에 실패했습니다."),
	DATABASE_EXCEPTION(HttpStatus.BAD_REQUEST, "U02", "API 서버가 응답이 없습니다.");
	
	private final HttpStatus status;
	private final String code;
	private String message;
	
	ApiStatusEnum(HttpStatus status, String code) {
		this.status = status;
		this.code = code;
	}	

	ApiStatusEnum(HttpStatus status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
}
