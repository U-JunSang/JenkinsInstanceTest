<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 로그인 페이지</title>
</head>
<body>
msg:${msg}

${user}

<form action="./logingo.do" method="POST">
아이디 : 
<input type="text" name="id">:
비밀번호
<input type="text" name="password">
<input name="remember-me" type="checkbox" value="true"> : Remember me 
<input type="submit" value="제출">
</form>

<a href="./singUpgo.do">회원가입</a>

</body>
</html>















