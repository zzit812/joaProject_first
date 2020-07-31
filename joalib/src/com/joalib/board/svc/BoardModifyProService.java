package com.joalib.board.svc;

import static com.joalib.board.CONN.JdbcUt.getConnection;
import static mvcpr.board.CONN.JdbcUt.close;

import java.sql.Connection;

import com.joalib.DAO.DAO;
import com.joalib.DTO.BoardDTO;

public class BoardModifyProService {

	public void modifyArticle(BoardDTO article) {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		DAO dao = new DAO();
		dao.setConnection(con);
		System.out.println("디비로 갈거셈");
		dao.board_update(article);
		close(con);	
		System.out.println("디비작업완료!");
	}





}
