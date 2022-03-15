package se.app.testdrive;

import org.springframework.stereotype.Service;

import se.mapper.app.TestdriveMapper;
import se.mapper.app.UsedcarFMCMapper;

@Service
public class UsedcarFMCServiceImpl implements UsedcarFMCService {

	private UsedcarFMCMapper ufm;
	
	public UsedcarFMCServiceImpl(UsedcarFMCMapper ufm) {
		super();
		this.ufm = ufm;
	}

	@Override
	public Integer registerUsedcarFMCRequest(UsedcarFMCRequestDto ufo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsedcarFMCRequestDto searchUsedcarFMCRequest(Integer request_number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
