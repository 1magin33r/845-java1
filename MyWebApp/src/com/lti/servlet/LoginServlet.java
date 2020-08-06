package com.lti.servlet;


import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.services.DatabaseLoginService;
import com.lti.services.InMemoryLoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.lti")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		//InMemoryLoginService loginService = new InMemoryLoginService();
		DatabaseLoginService loginService = new DatabaseLoginService();
		
		boolean isValid = loginService.authenticate(uname, pwd);
		if(isValid) {
			String rememberMe = request.getParameter("reme");
			if(rememberMe != null && rememberMe.equals("yes")) {
				Cookie c1 = new Cookie("uname", uname);
				c1.setMaxAge(60 * 60);
				Cookie c2 = new Cookie("upass", Base64.getEncoder().encodeToString(pwd.getBytes()));
				c2.setMaxAge(60 * 60);
				
				response.addCookie(c1);
				response.addCookie(c2);
			}
			response.sendRedirect("welcome.html");
		}
		else
			response.sendRedirect("login.html");
		
	}

}
