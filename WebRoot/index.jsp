<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
  </head>
  
  <body>
   <div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
		</div>
		<div class="span6">
			<form class="form-horizontal" action="servlet/ConnectServlet" method="get">
				<fieldset>
					<div id="legend">
					</div> <legend>连接微信服务器获取<span>AccessToken</span></legend>
					<div class="control-group">
						<label class="control-label" for="input01">corpid</label>
						<div class="controls">
							<input class="input-xlarge" type="text" name="corpid"/>
							<p class="help-block">
								wx8ed6d8cf9a58ac85
							</p>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="input01">*corpsecret</label>
						<div class="controls">
							<input class="input-xlarge" type="text" name="corpsecret"/>
							<p class="help-block">
								TsSFZovEkCUB5RFa-yf5HzAgMCgBf8HtfFpD9IA-DXYn7q6FmxcxuORtd3ejm9R7
							</p>
						</div>
					</div>
				</fieldset> <span><button class="btn" type="submit">连接</button></span>
			</form>
		</div>
		<div class="span3">
		</div>
	</div>
</div>
  </body>
</html>
