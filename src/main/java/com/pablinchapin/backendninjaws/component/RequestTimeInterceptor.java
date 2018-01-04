package com.pablinchapin.backendninjaws.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger LOG = Logger.getLogger(RequestTimeInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		request.setAttribute("startTime", System.currentTimeMillis());
		
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		long startTime = (long) request.getAttribute("startTime");
		LOG.info("--REQUEST URL: '" + request.getRequestURL().toString() + "' --TOTAL TIME: '" + (System.currentTimeMillis() - startTime) + "' ms");
	}
	
}