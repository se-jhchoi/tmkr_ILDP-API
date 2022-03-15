package se.app.testdrive;

public interface UsedcarFMCService {
		
	public Integer registerUsedcarFMCRequest(UsedcarFMCRequestDto ufo) throws Exception;
	
	public UsedcarFMCRequestDto searchUsedcarFMCRequest(Integer request_number) throws Exception;
		
}
