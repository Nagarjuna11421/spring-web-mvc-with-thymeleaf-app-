package com.spring.web.interceptor;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.spring.web.controller.ProductController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LogInterceptor implements HandlerInterceptor {


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println();
		// timr generated in millisec
		long startTime = System.currentTimeMillis();
		
		System.out.println("Request Start Time : " + startTime); 
		System.out.println("Request Method Type : " + request.getMethod()); // http method name
		System.out.println("Request URL : " + request.getRequestURL()); // api request url pattern

		request.setAttribute("StartTime", startTime);

		System.out.println("Server Name: " + request.getServerName());

		// set query param to check every request comes from client or not to process the request
		// at the end of URL type ?key=value . Ex:  ?myId=nag
		String parameter = request.getParameter("myId");
		if ("nag".equals(parameter)) {
			return true;
		}
		response.getWriter().print("invalid request.");
		return false;

		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		// generate time in milli sec
		long endTime = System.currentTimeMillis();
	
		System.out.println("Request End Time : " + endTime); // 
		System.out.println("Request Method Type : " + request.getMethod()); // http method name
		System.out.println("Request URL : " + request.getRequestURL()); // api request url pattern

		// get start time attribute from preHandler where it is set the time
		long startTime = (long) (request.getAttribute("StartTime"));
		// process time calculation
		long time = endTime - startTime;
		System.out.println("Process Time : " + time);
		
		// response code
		System.out.println("Respone Status : " + response.getStatus());
		
		//  content type set and get
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("Respone Type: " + response.getContentType());
		
		//response class name
		System.out.println(response.getClass().getName());
		System.out.println();
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

}
