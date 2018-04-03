<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

</head>
<body>

<form action="${pageContext.request.contextPath}/uploadfiles" method="post" enctype="multipart/form-data">
	<input type="file" name="image">
	<input type="submit" value="提交">
</form>
</body>
</html>