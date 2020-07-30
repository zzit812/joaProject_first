package mvcpr.board.Serv;

import static mvcpr.board.CONN.JdbcUt.close;
import static mvcpr.board.CONN.JdbcUt.commit;
import static mvcpr.board.CONN.JdbcUt.getConnection;
import static mvcpr.board.CONN.JdbcUt.rollback;
import java.sql.Connection;
import mvcpr.board.DAO.BoardDAO;

public class BoardDeleteProService {

	public boolean isArticleWriter(int board_num, String pass) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isArticleWriter = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		isArticleWriter = boardDAO.isArticleBoardWriter(board_num, pass);
		close(con);
		return isArticleWriter;
		
	}

	public boolean removeArticle(int board_num) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isRemoveSuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int deleteCount = boardDAO.deleteArticle(board_num);
		
		if(deleteCount > 0){
			commit(con);
			isRemoveSuccess=true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isRemoveSuccess;
	}

}
