package com.joalib.DAO;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.joalib.DTO.memberinfoDTO;

public class memberinfoDAO {
	
	SqlSessionFactory sqlfactory;
	
	//싱글톤 패턴
	private static memberinfoDAO instance;	
	
	public static memberinfoDAO getinstance() {
		if (instance == null) {	// >DAO 객체 만든적 있어?
			synchronized (DAO.class) {
				instance = new memberinfoDAO();		}
		}
		return instance;
	}	
	
	public memberinfoDAO(){	
		try {
			Reader reader = Resources.getResourceAsReader("com/joalib/DAO/mybatis_test-config.xml");		//xml 연결
			sqlfactory = new SqlSessionFactoryBuilder().build(reader);	//batis를 증명하는 아이.				
		} catch (IOException e) {
			e.printStackTrace();		
			}		
	}
	//	
	
	//insert
	public int memberInsert (memberinfoDTO dto) {
		SqlSession sqlsession = sqlfactory.openSession();		
		int i = sqlsession.insert("memberInsert", dto);
		System.out.println("회원가입이 완료되었습니다.");
		sqlsession.commit();
		sqlsession.close();
		
		return i;
	}
	
	//id 체크하고 pw값은 받아옴
	public String memberIDCheck(String checkID) {
		SqlSession sqlsession = sqlfactory.openSession();		
		String pw = sqlsession.selectOne("memberLoginCheck", checkID);
		sqlsession.commit();
		sqlsession.close();
		
		return pw;
	}
	
}
