package se.mapper.app;

import org.springframework.stereotype.Repository;
import se.app.homepage.usedcar.UsedcarFMCRequestDto;

@Repository
public interface UsedcarFMCMapper {
    public Integer insertFMCRequest(UsedcarFMCRequestDto tdo) throws Exception;

    public UsedcarFMCRequestDto selectOneFMCRequest(Integer request_number) throws Exception;
}
