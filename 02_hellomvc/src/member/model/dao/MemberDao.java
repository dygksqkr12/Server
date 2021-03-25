package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.vo.Member;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		String fileName = 
			MemberDao.class
					 .getResource("/sql/member/member-query.properties")
					 .getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Member selectOne(Connection conn, String memberId) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOne");
		
		try {
			//1. PreparedStatement객체 생성, 미완성 쿼리 값대입
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			//2. 쿼리 실행, ResultSet => Member
			rset = pstmt.executeQuery();
			while(rset.next()) {
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setPassword(rset.getString("password"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberRole(rset.getString("member_role"));
				m.setGender(rset.getString("gender"));
				m.setBirthday(rset.getDate("birthday"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddress(rset.getString("address"));
				m.setHobby(rset.getString("hobby"));
				m.setEnrollDate(rset.getDate("enroll_date"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//3. ResultSet, PreparedStatement객체 반납
			close(rset);
			close(pstmt);
		}
		
//		System.out.println("member@dao="+m);
		
		return m;
	}

}