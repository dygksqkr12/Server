package member.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {

	private MemberDao memberDao = new MemberDao();

	public Member selectOne(String memberId) {
		//1. Connection객체 생성
				Connection conn = getConnection();
				//2. dao에 Connection객체, memberId를 전달해서 Member객체를 리턴받음.
				Member m = memberDao.selectOne(conn, memberId);
				//3. Connection 자원반납
				close(conn);
				
//				System.out.println("member@service="+m);
				return m;
	}
}
