package mvcpr.board.Serv;

import java.sql.Connection;
import mvcpr.board.DAO.BoardDAO;
import mvcpr.board.DTO.Postexam;
import static mvcpr.board.CONN.JdbcUt.*;

public class BoardDetailService {

	public Postexam getArticle(int board_num) throws Exception{
		// TODO Auto-generated method stub
		
		Postexam article = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int updateCount = boardDAO.updateReadCount(board_num);
		
		if(updateCount > 0){
			commit(con);
		}
		else{
			rollback(con);
		}
		
		article = boardDAO.selectArticle(board_num);
		close(con);
		return article;
		
	}

}
