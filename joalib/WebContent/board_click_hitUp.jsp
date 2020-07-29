<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "com.joalib.board.action.board_HitUp" %>
  <%@ page import = "com.joalib.board.action.dbAction" %>
  <%@ page import = "com.joalib.DTO.BoardDTO" %>
    <%@ page import = "com.joalib.DAO.DAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선택 글 보기</title>
</head>
<body>
	<%
		dbAction act = null;
		
			if(request.getParameter("board_num") != null){
		//전페이지에서 가져온 게시글번호를 static 변수인 board_num에 넣어준다.
		BoardDTO dto = new BoardDTO();
		dto.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		
		act = new board_HitUp();
		act.start();	//hitup 실행
		response.sendRedirect("board_read_page.jsp");	//<임시> 글 조회창으로 이동 : 앞서 셋팅했던 board_num을 이용해서 
		//out.print("조회수 증가 완료");
		
		
			}else{
		out.print("null입니다.");
			}
	%>
</body>
</html>