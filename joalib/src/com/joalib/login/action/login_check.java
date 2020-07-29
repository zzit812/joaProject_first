package com.joalib.login.action;

import com.joalib.DAO.DAO;

public class login_check {
	
	DAO dao = new DAO();
	
	public login_check(){		
		DAO.getinstance();
	}
	
	public String idCheck(String id) {
		String pw = dao.idCheck(id);
		return pw;
	}
	

}
