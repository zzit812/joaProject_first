package com.joalib.board.svc;


import com.joalib.DAO.DAO;
import java.sql.Connection;

import com.joalib.DTO.BoardDTO;

public class BoardDetailService {

	public BoardDTO getArticle(int board_no) throws Exception {
		
		DAO dao = new DAO();		
		DAO.getinstance();
		
		dao.hitUp(board_no);	//��ȸ�� ����
		BoardDTO article = dao.read_details(board_no);	//board������ �о����
		
		
		return article;
	}
	

}
