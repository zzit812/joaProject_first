package com.joalib.DAO;


import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.joalib.DTO.BoardDTO;
import com.joalib.DTO.memberinfoDTO;

import com.joalib.DTO.BoardDTO;

public class DAO {
	Connection con;  //����,MVC2���� �ϸ鼭 �߰�
	
	SqlSessionFactory sqlfactory;
	
	////////////////////// ��Ŭ������ //////////////////////
	
	private static DAO instance;
	
	//static�� �ݵ��! �پ���Ѵ�. ���� ����
	public static DAO getinstance() {
		if (instance == null) {	// >DAO ��ü ������ �־�?
			synchronized (DAO.class) {
				instance = new DAO();
			}
		}
		return instance;
	}
	
	public void setConnection(Connection con){
		this.con = con;
	}//����,MVC2���� �ϸ鼭 �߰�
	
	
	
	public DAO(){	
		try {
			Reader reader = Resources.getResourceAsReader("com/joalib/DAO/mybatis_test-config.xml");		//xml ����
			sqlfactory = new SqlSessionFactoryBuilder().build(reader);	//batis�� �����ϴ� ����.				
		} catch (IOException e) {
			e.printStackTrace();		
			}		
	}	
	
	////////////////////////////////////////////////////////////////
	//join
	public void member_insert (memberinfoDTO dto) {
		SqlSession sqlsession = sqlfactory.openSession();		
		sqlsession.insert("member_insert", dto);
		//System.out.println(dto.getMember_id());
		System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
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
	public List<BoardDTO> select_board_all() {	//��ü�� �̾ƿ���
		getinstance();
		SqlSession sqlsession = sqlfactory.openSession();
		List <BoardDTO> list = sqlsession.selectList("board_all");
		sqlsession.commit();
		sqlsession.close();
		return list;
	}
	
	public int select_board_total() {	//�ѰԽù� ����
		getinstance();
		SqlSession sqlsession = sqlfactory.openSession();
		int total = sqlsession.selectOne("board_count");
		sqlsession.commit();
		sqlsession.close();
		return total;
	}
	
	public void hitUp(int board_no) {		//��ȸ�� ����
		SqlSession sqlsession = sqlfactory.openSession();
		sqlsession.update("board_hitUp", board_no);
		System.out.println(" *SQL����Ϸ�* ");
		sqlsession.commit();
		sqlsession.close();
		
	}	
	public BoardDTO read_details(int board_no) {
		SqlSession sqlsession = sqlfactory.openSession();
		BoardDTO dto = new BoardDTO();
		dto = sqlsession.selectOne("read_details", board_no);
		sqlsession.commit();
		sqlsession.close();
		return dto;		
	}
	
	public int myinsert(BoardDTO dto) {
		SqlSession sqlsession = sqlfactory.openSession();
		int i = sqlsession.insert("board_add", dto);
		sqlsession.commit();
		sqlsession.close();
		
		return i;
		//������...��� ���尡 �Ǵ� �ȵǴ� Ʈ����;
	}

	
	public void board_del(int board_no) {
		SqlSession sqlsession = sqlfactory.openSession();
		BoardDTO board_dto = new BoardDTO();
		sqlsession.delete("board_del", board_no);
		sqlsession.commit();
		sqlsession.close();
	}
	
	public int board_update(BoardDTO article) {
		SqlSession sqlsession = sqlfactory.openSession();
		int i = sqlsession.update("board_update", article);
		sqlsession.commit();
		sqlsession.close();
		
		return i;
	}




	
	
	
	
}




