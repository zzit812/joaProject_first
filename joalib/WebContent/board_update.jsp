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
				String no= request.getParameter("board_no");
				int board_no =Integer.parseInt(no);
				
				DTO dto = new DTO();
				DAO dao = new DAO();
				
				dto.setBoard_title(board_title);
				dto.setBoard_text(board_text);
				dto.setBoard_no(board_no);
				
				DAO.getinstance();
				dao.board_update(dto);
				
				response.sendRedirect("board.jsp");
                
				%>