package se.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoggerInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
    CommonService commonService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		RequestLogDto requestLogDto = new RequestLogDto();
		requestLogDto.setReq_protocol(request.getProtocol());
		requestLogDto.setReq_contexttype(request.getContentType());
		requestLogDto.setReq_method(request.getMethod());
		requestLogDto.setReq_path(request.getPathInfo());
		requestLogDto.setReq_data(request.getReader().readLine());
		requestLogDto.setReg_user_id("SYSTEM");
		
		commonService.insertRequestLog(requestLogDto);
		
		request.getSession().setAttribute("log_seq", requestLogDto.getLog_seq());
		
		return super.preHandle(request, response, handler);
	}
}
