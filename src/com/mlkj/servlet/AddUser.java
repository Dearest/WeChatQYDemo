package com.mlkj.servlet;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mlkj.utils.HttpRequest;

public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 7460284262174547864L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String accessToken = (String)this.getServletContext().getAttribute("accessToken");
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String position = request.getParameter("position");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String weixinid = request.getParameter("weixinid");
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("name", name);
		map.put("department", department);
		map.put("position", position);
		map.put("mobile", mobile);
		map.put("email", email);
		map.put("weixinid", weixinid);
		
		
		URL url = new URL("https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token="+accessToken);
		HttpRequest httpRequest = HttpRequest.post(url).form(map);
		
		JSONObject resultJson = JSONObject.fromObject(httpRequest.body());
		System.out.println(resultJson.toString());
		if (resultJson.getInt("errcode") == 0) {
			//
			request.getRequestDispatcher("/wechatqy").forward(request,response);
		}else {
			System.out.println("errmsg:"+resultJson.getString("errmsg"));
			request.getRequestDispatcher("/wechatqy").forward(request,response);
		}
		
	
		
		
	}
	

}
