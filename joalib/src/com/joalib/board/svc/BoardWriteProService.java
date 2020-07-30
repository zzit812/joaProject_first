package com.joalib.board.svc;

import static com.joalib.board.CONN.JdbcUt.getConnection;
import static com.joalib.board.CONN.JdbcUt.close;
import static com.joalib.board.CONN.JdbcUt.commit;
import static com.joalib.board.CONN.JdbcUt.rollback;

import java.sql.Connection;

import com.joalib.DAO.DAO;
import com.joalib.DTO.BoardDTO;

public class BoardWriteProService {

	public boolean registArticle(BoardDTO boardBean) throws Exception{
	
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		DAO dao = DAO.getinstance();
		dao.setConnection(con);
		int insertCount = dao.myinsert(boardBean);
		
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
