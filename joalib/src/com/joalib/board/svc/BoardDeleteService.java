package com.joalib.board.svc;

import static com.joalib.board.CONN.JdbcUt.getConnection;
import java.sql.Connection;

import com.joalib.DAO.DAO;

public class BoardDeleteService {

	public void removeArticle(int board_no) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		DAO dao = new DAO();
		dao.setConnection(con);
		dao.board_del(board_no);
		
	}

}
