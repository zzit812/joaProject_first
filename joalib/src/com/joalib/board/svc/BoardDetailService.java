package com.joalib.board.svc;

import static com.joalib.board.CONN.JdbcUt.getConnection;
import com.joalib.DAO.DAO;
import java.sql.Connection;

import com.joalib.DTO.BoardDTO;

public class BoardDetailService {

	public BoardDTO getArticle(int board_no) throws Exception {
		// TODO Auto-generated method stub
		
		BoardDTO article = null;
		Connection con = getConnection();
		DAO dao = new DAO();
		///////////////////////////////////
		dao.setConnection(con);
		
		dao.hitUp(board_no);
		article = dao.read_details(board_no);
		
		
		return article;
	}
	

}
