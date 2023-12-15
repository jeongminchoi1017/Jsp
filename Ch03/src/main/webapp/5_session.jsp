<%@page import="sub1.UserVO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>5_session</title>
		<!-- 
			날짜 : 2023/07/26
			이름 : 최정민
			내용 : JSP session 내장객체 실습하기
			
			session
			 - session은 최초 요청부처 마지막 요청까지의 전체 시간 경과
			 - 클라이언트에 대응되는 객체, 서버에 기록되는 클라이언트 고유번호(Session Table)
			 - 서버(WAS)는 각 클라이언트에 대한 고유식별번호(Session ID, SID)를 자동으로 발급 
		 -->
	</head>
	<body>
		<h3>5.session 내장객체</h3>
		
		<h4>session ID 확인</h4>
		<!-- 자동으로 생성되는 고유식별번호 -->
		<%= session.getId() %>
		
		<h4>session 설정</h4> 
		<%
			UserVO user = new UserVO("a101", "김유신", "010-1234-1001", 23);
			
			// session table에 userColumn 컬럼명으로 user 객체 저장	
			session.setAttribute("userColumn", user);
			
			// session table에 저장된 userColumn 컬럼 값을 가져옴
			UserVO userVO = (UserVO) session.getAttribute("userColumn");
		%>
		
		<p>
			아이디 : <%= userVO.getUid() %><br>
			이름 : <%= userVO.getName() %><br>
			휴대폰 : <%= userVO.getHp() %><br>
			나이 : <%= userVO.getAge() %><br>
		</p>
		
		
		
		
	</body>
</html>