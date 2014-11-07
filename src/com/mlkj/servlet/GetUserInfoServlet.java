package com.mlkj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mlkj.utils.HttpRequest;

public class GetUserInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpRequest result = HttpRequest
				.get(new URL(
						"http://in.qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ETlEHzy1WQR4Sy19qIGi6I1gAOvB4H4nZUlDpSMBltcHpIy2EUyEeP5EOcbRrz1V&userid=hanchen"));

		
		System.out.println(result.body());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
