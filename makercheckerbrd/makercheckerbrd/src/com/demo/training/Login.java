/*
 * Classname:Login
*
 * Version info:0.01
 *
 * Copyright notice
 */

package com.demo.training;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// validation of user and password

		//String s = (String)HttpContext.Current.Session["uname"];

		String userId = request.getParameter("uname");
		String usertype = request.getParameter("usertype");
		String password = request.getParameter("psw");
		System.out.println(password);

		if (Repository.validateLogin(userId, password, usertype)) {
			if (usertype.equals("maker")) {
				response.sendRedirect("selection.html");

			} else {
				response.sendRedirect("checker.html");
			}
		} else {
			response.sendRedirect("error.html");
		}
	}
}
