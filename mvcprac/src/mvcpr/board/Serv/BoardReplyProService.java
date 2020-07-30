package mvcpr.board.Serv;

import static mvcpr.board.CONN.JdbcUt.*;
import java.sql.Connection;
import mvcpr.board.DAO.BoardDAO;
import mvcpr.board.DTO.Postexam;

public class BoardReplyProService {

	public boolean replyArticle(Postexam article) throws Exception{
		
		boolean isReplySuccess = false;
		int insertCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		insertCount = boardDAO.insertReplyArticle(article);
		
		if(insertCount > 0){
			commit(con);
			isReplySuccess = true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isReplySuccess;
		
	}

}
