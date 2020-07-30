package com.joalib.DAO;

import static com.joalib.board.CONN.JdbcUt.close;

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
	
	public void hitUp() {		//��ȸ�� ����
		SqlSession sqlsession = sqlfactory.openSession();
		BoardDTO dto = new BoardDTO();
		sqlsession.update("board_hitUp", dto);
		System.out.println(" *SQL����Ϸ�* ");
		sqlsession.commit();
		sqlsession.close();
		
	}	
	public BoardDTO read_details() {
		SqlSession sqlsession = sqlfactory.openSession();
		BoardDTO dto = new BoardDTO();
		dto = sqlsession.selectOne("read_details", dto);
		sqlsession.commit();
		sqlsession.close();
		return dto;		
	}
	public int myinsert(BoardDTO dto) {
		SqlSession sqlsession = sqlfactory.openSession();
		dto = sqlsession.selectOne("board_add", dto);
		sqlsession.commit();
		sqlsession.close();
		
		return 1;
		//������...��� ���尡 �Ǵ� �ȵǴ� Ʈ����;
	}
	
//	public int insertArticle(BoardDTO article){
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int num =0;
//		String sql="";
//		int insertCount=0;
//
//		try{
//			pstmt=con.prepareStatement("select max(board_no) from board");
//			rs = pstmt.executeQuery();
//
//			if(rs.next())
//				num =rs.getInt(1)+1;
//			
//			
//			else
//				num=1;
//
//			sql="insert into board (board_no,board_title,board_text,board_date,member_id,board_hit)"
//					+ "values(default,?,?,now(),?,?)";
//			
//			
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, article.getBoard_title());
//			pstmt.setString(2, article.getBoard_text());
//			pstmt.setString(3, article.getMember_id());
//			pstmt.setInt(4, 0);
//
//			insertCount=pstmt.executeUpdate();
//
//		}catch(Exception ex){
//		}finally{
//			close(rs);
//			close(pstmt);
//		}
//
//		return insertCount;
//
//	}
	
	
	public void board_del() {
		SqlSession sqlsession = sqlfactory.openSession();
		BoardDTO board_dto = new BoardDTO();
		sqlsession.delete("board_del", board_dto);
		sqlsession.commit();
		sqlsession.close();
	}
	
	public void board_update(BoardDTO dto) {
		System.out.println("1");
		SqlSession sqlsession = sqlfactory.openSession();
		System.out.println("2");
		sqlsession.selectOne("board_update", dto);
		System.out.println("3");
		sqlsession.commit();
		sqlsession.close();
	}
	
	
	
	
}




