package com.joalib.member.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.joalib.DAO.*;
import com.joalib.DTO.ActionForward;
import com.joalib.member.svc.MemberIDCheckService;

public class MemberIDCheck implements Action{
	

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;		
		ServletContext context = request.getServletContext();	//���� �������� servletContext�� �޾ƿ���,
		
		String checkID = request.getParameter("member_id");
		String checkPW = request.getParameter("member_pw");
		
		MemberIDCheckService svc = new MemberIDCheckService();
		String member_pw = svc.IDCheck(checkID);

				
		if(checkPW.equals(member_pw) && member_pw != null) {
			//�ִ� ���̵� && ������ ��й�ȣ
			//���ǿ� ����
			HttpSession session = request.getSession();
	        session.setAttribute("member_id",checkID);
	        
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("mypage_main.jsp");
		}else {
			//���� ���̵� && �������� ���� ��й�ȣ
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();	//�� ���� Writer�� �θ���?
			out.println("<script>");
			out.println("alert('�������� ���� ȸ���̰ų�, �߸��� ��й�ȣ �Դϴ�.')");
			out.println("history.back();"); //local.href=""
			out.println("</script>");
		}
		
		return forward;
	}
	
	
//	public String IDCheck(String checkID) throws Exception {
//		
//		String message = null;
////		response.setContentType("text/html;charset=UTF-8");
////		PrintWriter out = response.getWriter();	//�� ���� Writer�� �θ���?
//		MemberIDCheckService svc = new MemberIDCheckService();
//		if(svc.IDCheck(checkID) != null) {
//			//�ִ� ���̵�
//			message = "������� ���̵��Դϴ�";
//		}else {
//			//���� ���̵�
//			message = "����� �� �ִ� ���̵��Դϴ�";
//		}
//		
//		
//		return message;
//	}
	

}
