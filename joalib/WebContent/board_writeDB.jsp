<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page import="java.util.*,java.text.*" %>
<%@ page import="db_table_dao.DAO" %>
<%@ page import="db_board_dto.DTO" %>

<%  			

				request.setCharacterEncoding("UTF-8");
				String board_title= request.getParameter("board_title");
				String board_text= request.getParameter("board_write");
				
				String member_id = null;
				member_id = (String)session.getAttribute("member_id");
		
				Date date= new Date();
				SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
				String board_date = simpleDate.format(date);
				
				DTO dto = new DTO();
			    DAO dao = new DAO();
				
				dto.setMember_id(member_id);
				dto.setBoard_title(board_title);
				dto.setBoard_text(board_text);
				dto.setBoard_date(board_date);
				
				DAO.getinstance();
				dao.myinsert(dto);
			
                response.sendRedirect("board.jsp");			    
                

				%>