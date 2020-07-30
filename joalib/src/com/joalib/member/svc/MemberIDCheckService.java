package com.joalib.member.svc;

import com.joalib.DAO.memberinfoDAO;

public class MemberIDCheckService {
	
	public String IDCheck (String checkID) throws Exception {
		
		//boolean IDCheckSuccess = false;
		memberinfoDAO dao = new memberinfoDAO();
		String pw = dao.memberIDCheck(checkID);
		
		
		if(pw == null) {			
			//IDCheckSuccess = true;
			
		}
		
		return pw;
	}

}