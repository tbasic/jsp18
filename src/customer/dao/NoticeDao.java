package customer.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import customer.db.DBCon;
import customer.vo.Notice;

public class NoticeDao {
	
	// 테이블의 모든 행(동그랑땡)을 가져오기 위해 list사용
	public List<Notice> noticeSelAll(String field,String query) throws Exception{
		
		// DB접속, 결과 조회
		Connection con=DBCon.getConnection();
		// String sql="SELECT * FROM notices ORDER BY to_number(seq) DESC";
		String sql="SELECT * FROM notices WHERE "+field+" like ? ORDER BY to_number(seq) DESC";
		
		// 실행
		// Statement st=con.createStatement();
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, "%"+query+"%");
		
		// 결과
		// ResultSet rs=st.executeQuery(sql); // sql의 결과값을 ResultSet에 담는다
		ResultSet rs=pstmt.executeQuery();
		
		// List에 Notice내용 담기
		List<Notice> list=new ArrayList<Notice>();
		
		while(rs.next()) {
			Notice n=new Notice();
			n.setSeq(rs.getString("seq")); // 앞에 seq는 Notice의 seq변수를 의미하고 뒤에 seq는 디비에 있는 seq값을 의미함(디비 내용을 가져와서 Notice에 넣어주는 것)
			n.setTitle(rs.getString("title"));
			n.setWriter(rs.getString("writer"));
			n.setContent(rs.getString("content"));
			n.setRegdate(rs.getDate("regdate"));
			n.setHit(rs.getInt("hit"));
			
			list.add(n);

		}
		rs.close();
		pstmt.close();
		con.close();
		
		return list;
	}
	
	
}
