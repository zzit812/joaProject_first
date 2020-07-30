package com.joalib.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joalib.DTO.ActionForward;
import com.joalib.DTO.BoardDTO;
import com.joalib.board.svc.BoardDetailService;

public class BoardModifyFormAction implements dbAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		int board_no=Integer.parseInt(request.getParameter("board_num"));
	
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardDTO article = boardDetailService.getArticle(board_no);
		
		request.setAttribute("article", article);
		forward.setPath("/board_update_page.jsp");
		return forward;
	}

}
