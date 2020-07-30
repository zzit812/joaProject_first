package mvcpr.board.Serv;

import java.sql.Connection;
import mvcpr.board.DAO.BoardDAO;
import mvcpr.board.DTO.Postexam;
import static mvcpr.board.CONN.JdbcUt.*;
public class BoardWriteProService {

	public boolean registArticle(Postexam boardBean) throws Exception{
		
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int insertCount = boardDAO.insertArticle(boardBean);
		
		if(insertCount > 0){
			commit(con);
			isWriteSuccess = true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isWriteSuccess;
		
	}

}
