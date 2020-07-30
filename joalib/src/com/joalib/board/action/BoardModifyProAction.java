package com.joalib.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joalib.DTO.ActionForward;
import com.joalib.DTO.BoardDTO;

import com.joalib.board.svc.BoardModifyProService;

public class BoardModifyProAction implements dbAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int board_num=0;
		ActionForward forward = null;
		
		board_num=Integer.parseInt(request.getParameter("board_no"));
		BoardDTO article= new BoardDTO();
		BoardModifyProService boardModifyProService = new BoardModifyProService();
		
		article.setBoard_title(request.getParameter("board_title"));
		article.setBoard_text(request.getParameter("board_write"));
		article.setBoard_num(board_num);
		boardModifyProService.modifyArticle(article);
		
		
		forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("boardList.bo"); 
		
		
		return forward;
	}

}
