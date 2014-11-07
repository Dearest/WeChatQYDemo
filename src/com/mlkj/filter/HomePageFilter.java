package com.mlkj.filter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mlkj.model.User;
import com.mlkj.utils.HttpRequest;

/**
 * @author hanchen 拦截index.html
 * 
 */
public class HomePageFilter implements Filter {
	private List<User> users = new ArrayList<>();

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		String accessToken = (String) request.getServletContext().getAttribute(
				"accessToken");
		String departmentId = "4";
		System.out.println("token：" + accessToken);
		// GET 请求获取成员列表
		URL url = new URL(
				"https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token="
						+ accessToken
						+ "&department_id="+departmentId+"&fetch_child=0&status=0");
		System.out.println(url.toString());
		HttpRequest result = HttpRequest.get(url).connectTimeout(3000);

		if (result.ok()) {
			JSONObject resultJson = JSONObject.fromObject(result.body());
			System.out.println(resultJson.toString());
			if (resultJson.getInt("errcode") == 0) {
				JSONArray userArray = resultJson.getJSONArray("userlist");
				// 遍历json数组 将每个成员放到list里
				for (int i = 0; i < userArray.size(); i++) {
					JSONObject userJson = userArray.getJSONObject(i);
					User user = new User();
					user.setId(i + 1);
					user.setUserId(userJson.getString("userid"));
					user.setName(userJson.getString("name"));
					users.add(user);
				}
			}
		}
		// 把users放在request是属性里 方便在freemaker里使用
		request.setAttribute("users", users);
		request.getRequestDispatcher("WEB-INF/template/showuser.html").forward(
				request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
