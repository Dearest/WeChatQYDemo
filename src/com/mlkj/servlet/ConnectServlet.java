package com.mlkj.servlet;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.mlkj.utils.HttpRequest;

/**
 * 被废弃，不用了 
 * @author hanchen
 *
 */
public class ConnectServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String corpsecret = request.getParameter("corpsecret");
		String corpid = request.getParameter("corpid");
		
		
		System.out.println("corpid:"+corpid);
		System.out.println("secret:"+corpsecret);
		
		
		URL  url = new URL("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+corpid+"&corpsecret="+corpsecret);
		HttpRequest httpRequest = HttpRequest.get(url);
		
		
		String result = httpRequest.body();
		System.out.println("result:"+result);
		JSONObject jsonObject = JSONObject.fromObject(result);
		String accessToken = jsonObject.getString("access_token");
		System.out.println("acceccToken:"+accessToken);
		
		
		
		HttpSession session = request.getSession();
		
		
		ServletContext servletContext = session.getServletContext();
		servletContext.setAttribute("Acess_token", accessToken);
		
		request.getRequestDispatcher("../token.jsp").forward(request, response);
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
