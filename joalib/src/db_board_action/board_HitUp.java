package db_board_action;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db_board_action.dbAction;
import db_table_dao.DAO;

public class board_HitUp implements dbAction {

	@Override
	public void start() {
		DAO dao = DAO.getinstance();	//ΩÃ±€≈Ê ∆–≈œ
		dao.hitUp();	
		
	}
	
	
	
}


