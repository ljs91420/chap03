<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 연습하는 곳</title>
</head>
<body>
	<h3>세션 연습하기</h3>
	
	<p>
		일단 한 번 세션 객체에 값을 등록해놓으면 해당 세션이 만료되기 전까지는 해당 값이 계속 존재하게 된다.(로그인 결과, 오늘 하루 더 이상 보지 않음 등)
	</p>
	
	<p>로그인을 성공한 적이 있는 사용자는 로그인 폼 대신 로그아웃 버튼이 보인다.</p>
	
	<% if (session.getAttribute("login") != null) { %>
		''님은 이미 로그인 중입니다. <button>로그아웃</button>
	<% } else { %>
		<form id="loginForm" action="/chap03/user/login" method="POST">
			ID : <input id="userIdInput" type="text" name="user_id" value="testuser" /> <br>
			PW : <input id="userPwInput" type="password" name="user_password" value="1234" /> <br>
		</form>
		<button id="loginBtn">로그인</button>
	<% } %>
	
	<!-- 자바스크립트로 폼 submit 하기 -->
	<script src="./form_submit.js"></script>
</body>
</html>