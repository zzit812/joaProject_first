package mvcpr.board.Serv;

import static mvcpr.board.CONN.JdbcUt.*;
import java.sql.Connection;
import java.util.ArrayList;
import mvcpr.board.DAO.BoardDAO;
import mvcpr.board.DTO.Postexam;;

public class BoardListService {

	public int getListCount() throws Exception{
		int listCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		listCount = boardDAO.selectListCount();
		close(con);
		return listCount;
		
	}

	public ArrayList<Postexam> getArticleList(int page, int limit) throws Exception{
		
		ArrayList<Postexam> articleList = null;
		Connection con = getConnection(); //import java.sql.connection; 해줬음 이거 디비연결문.
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		articleList = boardDAO.selectArticleList(page,limit);
		close(con);
		return articleList;
		
	}

}
