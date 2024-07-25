<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보</title>
</head>
<body>
	이름 : <%=request.getAttribute("first_name") %> <br>
	성 : <%=request.getAttribute("last_name") %> <br>
</body>
</html>