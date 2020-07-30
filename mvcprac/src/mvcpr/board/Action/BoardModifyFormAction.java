package mvcpr.board.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvcpr.board.Serv.BoardDetailService;
import mvcpr.board.DTO.ActionForward;
import mvcpr.board.DTO.Postexam;

public class BoardModifyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
			int board_num=Integer.parseInt(request.getParameter("board_num"));
			BoardDetailService boardDetailService
			= new BoardDetailService();	
		   	Postexam article =boardDetailService.getArticle(board_num);
		   	request.setAttribute("article", article);
	   		forward.setPath("/qna_board_modify.jsp");
	   		return forward;
	   		
	 }
	 
}