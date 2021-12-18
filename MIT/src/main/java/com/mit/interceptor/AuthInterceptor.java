package com.mit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	private static final String LOGIN = "login"; 
	private static Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	private void saveDest(HttpServletRequest req) {
		
		String url = req.getRequestURI();
		String query = req.getQueryString(); 
		
		
		if(query == null || query.equals("null")) {
			query = "";
		} else {
			query = "?" + query;
		}
		
		
		if(req.getMethod().equals("GET")) { 
			logger.info("dest: " + (url + query)); 
			req.getSession().setAttribute("dest", url + query); 
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute(LOGIN) == null) {
			logger.info("current user is not logined");
			
			saveDest(request);
			
			response.sendRedirect("/member/login");
			return false;
		} /*else {
			MemberVO checkAuth = (MemberVO) session.getAttribute(LOGIN);
			
			if (checkAuth.getMemberNo() == 12345678) { // 관리자
				logger.info("admin access...");
			} else { // 회원
				logger.info("user access...");
				
				// 접근 하지 말아야 할 경로 인지 확인
				saveDest(request);
				String dest = (String) session.getAttribute("dest");
				
				logger.info("잘못된 접근...");
				response.sendRedirect("/");
				
				if (dest.contains("admin")) { //경로에 admin이 포함되면 리다이렉트
					logger.info("잘못된 접근...");
					response.sendRedirect("/");
				}
			}
		}*/
		return true;
	}
}
