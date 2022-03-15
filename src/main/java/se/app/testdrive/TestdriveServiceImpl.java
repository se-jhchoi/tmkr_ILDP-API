package se.app.testdrive;

import java.util.List;

import org.springframework.stereotype.Service;

import se.mapper.app.TestdriveMapper;

@Service
public class TestdriveServiceImpl implements TestdriveService {
	
	private TestdriveMapper tdm;
	
	public TestdriveServiceImpl(TestdriveMapper tdm) {
		super();
		this.tdm = tdm;
	}

	@Override
	public List<CommonCodeDto> searchCommonCode(CommonCodeDto cco) throws Exception {
		return tdm.selectListCommonCode(cco);
	}

	@Override
	public List<CommonCodeDto> searchShop(CommonCodeDto cco) throws Exception {
		return tdm.selectListShop(cco);
	}

	@Override
	public Integer registerRequest(TestdriveRequestDto tdo) throws Exception {
		tdm.insertRequest(tdo);
		return tdo.getRequest_number();
	}

	@Override
	public TestdriveRequestDto searchRequest(Integer request_number) throws Exception {
		return tdm.selectOneRequest(request_number);
	}

}
