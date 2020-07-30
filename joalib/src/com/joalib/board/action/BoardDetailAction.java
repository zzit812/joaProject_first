package com.joalib.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joalib.DTO.ActionForward;
import com.joalib.DTO.BoardDTO;
import com.joalib.board.svc.BoardDetailService;

public class BoardDetailAction implements dbAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardDetailAction�� �Դ�");
		int board_no =Integer.parseInt(request.getParameter("board_num"));
		System.out.println(board_no);
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardDTO article = boardDetailService.getArticle(board_no);
		//�ϳ��� �Խù��� ���� ������� �������
		
		ActionForward forward = new ActionForward();
		request.setAttribute("article", article);
		forward.setPath("/board_read_page.jsp");

		return forward;
	}

}
