package com.mlkj.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import net.sf.json.JSONObject;

public class GetAccessToken {
	private ServletContext context;
	private Timer timer = new Timer(true);
	
	public GetAccessToken(ServletContext context){
		System.out.println("构造方法");
		this.context = context;
		timer.schedule(task, 1000, 7000*1000);
	}
	private TimerTask task = new TimerTask() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				System.out.println("任务执行");
				URL url = new URL("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=wx8ed6d8cf9a58ac85&corpsecret=TsSFZovEkCUB5RFa-yf5HzAgMCgBf8HtfFpD9IA-DXYn7q6FmxcxuORtd3ejm9R7");
				HttpRequest httpRequest = HttpRequest.get(url);
				String result = httpRequest.body();
				System.out.println(result);
				JSONObject resultJsonObject = JSONObject.fromObject(result);
				if (result.contains("access_token")) {
					String accessToken = resultJsonObject.getString("access_token");
					context.setAttribute("accessToken", accessToken);
					context.setAttribute("errcode", null);
					context.setAttribute("errmsg", null);
				}else if(result.contains("errcode")){
					
					String errcode = resultJsonObject.getString("errcode");
					String errmsg = resultJsonObject.getString("errmsg");
					context.setAttribute("errcode", errcode);
					context.setAttribute("errmsg", errcode);
					context.setAttribute("accessToken", null);
					
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
}
