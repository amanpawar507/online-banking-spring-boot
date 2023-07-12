package com.sample.app1.sec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class InvalidUserAuthenticationEntryPoint implements AuthenticationEntryPoint {

//	@Override
//	public void commence(HttpServletRequest request, HttpServletResponse response,
//			AuthenticationException authException) throws IOException, ServletException {
//
//			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorhized User..");
//			
//			
//	}
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		if(response.getStatus()==401) {
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"PLease login to visit the URL");
		} else if(response.getStatus()==403) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN,"Your login is successful, but you don't have permission to view this page");
		}
			
			
	}

}
