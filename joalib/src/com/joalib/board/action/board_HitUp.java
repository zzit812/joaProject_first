package com.joalib.board.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.joalib.DAO.DAO;
import com.joalib.board.action.dbAction;

public class board_HitUp implements dbAction {

	@Override
	public void start() {
		DAO dao = DAO.getinstance();	//ΩÃ±€≈Ê ∆–≈œ
		dao.hitUp();	
		
	}
	
	
	
}


