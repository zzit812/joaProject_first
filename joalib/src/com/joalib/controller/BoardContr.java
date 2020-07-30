<<<<<<< HEAD
package com.joalib.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joalib.DTO.ActionForward;
import com.joalib.board.action.dbAction;

import com.joalib.board.action.BoardWriteProAction;


@WebServlet("*.bo")
public class BoardContr extends javax.servlet.http.HttpServlet
{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		dbAction action=null;
		
		if(command.equals("/boardWritePro.bo")){ //�۾��� �������Է� �� �Ϸ��ư ������ ��,
			action  = new BoardWriteProAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/boardList.bo")) {
			System.out.println("��ķ�");
		}
		
		
		
		
		
		if(forward != null) {
			
			if(forward.isRedirect()) {
				//boolean���� Ʈ���ΰ�쿡 ����
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher=
						request.getRequestDispatcher(forward.getPath());
				//RequestDispatcher��� Ŭ������ ���� request�� ��� ������ �����ϰ� �ִٰ�
				//�� ���� ������ �� �������������� �ش� ������ �� �� �ְ� ��� �����ϴ� ��
				//�Ѹ���� �Ķ�������� ������ ���� ����Ѵ�
				dispatcher.forward(request, response);
			
			}
			
			
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	} 
}
=======
package com.joalib.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joalib.DTO.ActionForward;

public class BoardContr extends javax.servlet.http.HttpServlet{
	protected void doProsecc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		
	}
}
>>>>>>> refs/remotes/origin/master
