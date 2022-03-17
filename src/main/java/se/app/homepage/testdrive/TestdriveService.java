package se.app.homepage.testdrive;

import se.app.homepage.CommonCodeDto;

import java.util.List;

public interface TestdriveService {
	
	public List<CommonCodeDto> searchCommonCode(CommonCodeDto cco) throws Exception;
	
	public List<CommonCodeDto> searchShop(CommonCodeDto cco) throws Exception;

	public List<CommonCodeDto> searchCenter(CommonCodeDto cco) throws Exception;

	public Integer registerRequest(TestdriveRequestDto tdo) throws Exception;
	
	public TestdriveRequestDto searchRequest(Integer request_number) throws Exception;
	
}