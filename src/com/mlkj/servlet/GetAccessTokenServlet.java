package com.mlkj.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.mlkj.utils.GetAccessToken;

/**
 * 在容器运行的时候加载 运行一个定时循环获取accessToken的线程
 * 
 * @author hanchen
 * 
 */
@SuppressWarnings("serial")
public class GetAccessTokenServlet extends HttpServlet {

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void init() throws ServletException {
		// Put your code here
		System.out.println("初始化");
		GetAccessToken getAccessToken = new GetAccessToken(
				this.getServletContext());
		// String token =
		// (String)this.getServletContext().getAttribute("accessToken");

	}

}
