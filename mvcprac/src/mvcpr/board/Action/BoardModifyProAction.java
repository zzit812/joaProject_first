package mvcpr.board.Action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvcpr.board.Serv.BoardModifyProService;
import mvcpr.board.DTO.ActionForward;
import mvcpr.board.DTO.Postexam;

public class BoardModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{
		int board_num=0;
		ActionForward forward = null;
		boolean isModifySuccess = false;
		
		board_num=Integer.parseInt(request.getParameter("BOARD_NUM"));
		if(  board_num == 0)
			board_num = 1;
		Postexam article=new Postexam();
		BoardModifyProService boardModifyProService = new BoardModifyProService();
		boolean isRightUser=boardModifyProService.isArticleWriter(board_num, request.getParameter("BOARD_PASS"));

		if(!isRightUser){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			article.setBOARD_NUM(board_num);
			article.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
			article.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT")); 
			isModifySuccess = boardModifyProService.modifyArticle(article);

			if(!isModifySuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패');");
				out.println("history.back()");
				out.println("</script>");
			}
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardDetail.bo?board_num="+article.getBOARD_NUM()); 
			}

		}

		return forward;
	}

}