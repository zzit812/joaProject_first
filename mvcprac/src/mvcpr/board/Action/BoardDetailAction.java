package mvcpr.board.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvcpr.board.Serv.BoardDetailService;
import mvcpr.board.DTO.ActionForward;
import mvcpr.board.DTO.Postexam;;

 public class BoardDetailAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
	   	
		int board_num=Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		
		BoardDetailService boardDetailService = new BoardDetailService();
		Postexam article = boardDetailService.getArticle(board_num);
		
		
		ActionForward forward = new ActionForward();
		request.setAttribute("page", page);
	   	request.setAttribute("article", article);
   		forward.setPath("/qna_board_view.jsp");
   		return forward;

	 }
	 
}