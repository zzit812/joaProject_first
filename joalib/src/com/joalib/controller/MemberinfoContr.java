package com.joalib.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.joalib.DTO.ActionForward;
import com.joalib.member.action.*;

import mvcpr.board.Action.BoardModifyFormAction;

@WebServlet("*.mem")
public class MemberinfoContr extends javax.servlet.http.HttpServlet{
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		Action action = null;
		
		if(command.equals("/memberInsert.mem")) {
			//회원가입
			action = new MemberInsertAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace(); }
		}else if(command.equals("/IDCheck.mem")) {
			//로그인
			action = new MemberIDCheck();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace(); }

		}else if(command.equals("/memberLogout.mem")) {
			//로그아웃
//			HttpSession session = request.getSession(false);
//			session.invalidate();
			//
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("userLogin.html");
		}
		
		
		
	
	
		if(forward != null){		
				if(forward.isRedirect()){
					response.sendRedirect(forward.getPath());	//반환하는 forward값이 있으면, 'forward.getPath()'으로 이동한다.
				}else{
					RequestDispatcher dispatcher=
							request.getRequestDispatcher(forward.getPath());
					dispatcher.forward(request, response);
				}
				
			}
	
	//doProcess END
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	} 
}