package se.app.homepage.usedcar;

import org.springframework.stereotype.Service;

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
		ufm.insertFMCRequest(ufo);
		return ufo.getRequest_number();
	}

	@Override
	public UsedcarFMCRequestDto searchUsedcarFMCRequest(Integer request_number) throws Exception {
		return ufm.selectOneFMCRequest(request_number);
	}

}
