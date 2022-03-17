package se.mapper.app;

import java.util.List;

import org.springframework.stereotype.Repository;

import se.app.homepage.CommonCodeDto;
import se.app.homepage.testdrive.TestdriveRequestDto;

@Repository
public interface TestdriveMapper {
	public List<CommonCodeDto> selectListCommonCode(CommonCodeDto cco) throws Exception;
	
	public List<CommonCodeDto> selectListShop(CommonCodeDto cco) throws Exception;

	public List<CommonCodeDto> selectListCenter(CommonCodeDto cco) throws Exception;

	public Integer insertRequest(TestdriveRequestDto tdo) throws Exception;
	
	public TestdriveRequestDto selectOneRequest(Integer request_number) throws Exception;
}
