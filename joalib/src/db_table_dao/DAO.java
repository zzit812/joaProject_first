package db_table_dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db_board_dto.DTO;
import db_member_dto.member_DTO;

public class DAO {
	
	SqlSessionFactory sqlfactory;
	
	////////////////////// 싱클톤패턴 //////////////////////
	
	private static DAO instance;
	
	//static이 반드시! 붙어야한다. 정적 변수
	public static DAO getinstance() {
		if (instance == null) {	// >DAO 객체 만든적 있어?
			synchronized (DAO.class) {
				instance = new DAO();
			}
		}
		return instance;
	}	
	
	public DAO(){	
		try {
			Reader reader = Resources.getResourceAsReader("db_table_dao/mybatis_test-config.xml");		//xml 연결
			sqlfactory = new SqlSessionFactoryBuilder().build(reader);	//batis를 증명하는 아이.				
		} catch (IOException e) {
			e.printStackTrace();		
			}		
	}	
	
	////////////////////////////////////////////////////////////////
	//join
	public void member_insert (member_DTO dto) {
		SqlSession sqlsession = sqlfactory.openSession();		
		sqlsession.insert("member_insert", dto);
		//System.out.println(dto.getMember_id());
		System.out.println("회원가입이 완료되었습니다.");
		sqlsession.commit();
		sqlsession.close();
	}
	
	////////////////////////////////////////////////////////////////
	//login
	public String idCheck (String id) {		
		SqlSession sqlsession = sqlfactory.openSession();		
		String pw = null;		
		pw = sqlsession.selectOne("memberID_Check",id);
		sqlsession.commit();
		sqlsession.close();
		return pw;
	}		
	
	
	////////////////////////////////////////////////////////////////
	//board
	public List<DTO> select_board_all() {	//전체를 뽑아오자
		getinstance();
		SqlSession sqlsession = sqlfactory.openSession();
		List <DTO> list = sqlsession.selectList("board_all");
		sqlsession.commit();
		sqlsession.close();
		return list;
	}
	
	public int select_board_total() {	//총게시물 갯수
		getinstance();
		SqlSession sqlsession = sqlfactory.openSession();
		int total = sqlsession.selectOne("board_count");
		sqlsession.commit();
		sqlsession.close();
		return total;
	}
	
	public void hitUp() {		//조회수 증가
		SqlSession sqlsession = sqlfactory.openSession();
		DTO dto = new DTO();
		sqlsession.update("board_hitUp", dto);
		System.out.println(" *SQL실행완료* ");
		sqlsession.commit();
		sqlsession.close();
		
	}	
	public DTO read_details() {
		SqlSession sqlsession = sqlfactory.openSession();
		DTO dto = new DTO();
		dto = sqlsession.selectOne("read_details", dto);
		sqlsession.commit();
		sqlsession.close();
		return dto;		
	}
	public void myinsert(DTO dto) {
		SqlSession sqlsession = sqlfactory.openSession();
		dto = sqlsession.selectOne("board_add", dto);
		sqlsession.commit();
		sqlsession.close();
	}
	
	public void board_del() {
		SqlSession sqlsession = sqlfactory.openSession();
		DTO board_dto = new DTO();
		sqlsession.delete("board_del", board_dto);
		sqlsession.commit();
		sqlsession.close();
	}
	
	public void board_update(DTO dto) {
		System.out.println("1");
		SqlSession sqlsession = sqlfactory.openSession();
		System.out.println("2");
		sqlsession.selectOne("board_update", dto);
		System.out.println("3");
		sqlsession.commit();
		sqlsession.close();
	}
	
	
	
	
}




