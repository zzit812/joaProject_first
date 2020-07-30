package mvcpr.board.Action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvcpr.board.Serv.BoardListService;
import mvcpr.board.DTO.ActionForward;
import mvcpr.board.DTO.Postexam;
import mvcpr.board.DTO.PageInfo;

 public class BoardListAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		ArrayList<Postexam> articleList=new ArrayList<Postexam>();
	  	int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}

		
		BoardListService boardListService = new BoardListService();
		//전체글수
		int listCount=boardListService.getListCount();
		
		articleList = boardListService.getArticleList(page,limit);
		//전체페이지수
   		int maxPage=(int)((double)listCount/limit   +0.95); //더해서 올림 처리.
   		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
   	        int endPage = startPage+10-1;

   		if (endPage> maxPage) endPage= maxPage;

   		PageInfo pageInfo = new PageInfo();
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);	
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		ActionForward forward= new ActionForward();
   		forward.setPath("/qna_board_list.jsp");
   		return forward;
   		
	 }
	 
 }