package customer.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import customer.db.DBCon;
import customer.vo.Notice;

public class NoticeDao {
	
	// 테이블의 모든 행(동그랑땡)을 가져오기 위해 list사용
	public List<Notice> noticeSelAll() throws Exception{
		
		// DB접속, 결과 조회
		Connection con=DBCon.getConnection();
		String sql="SELECT * FROM notices ORDER BY to_number(seq) DESC";
		//String sql="SELECT * FROM notices WHERE "+field+" like ? ORDER BY to_number(seq) DESC";
		
		// 실행
		// Statement st=con.createStatement();
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		
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
	public Notice getNotice(String seq,String hit) throws Exception { // 글번호에 맞는 Notice를 리턴받기
		int hnum=Integer.parseInt(hit);
//		hit update 함수로 처리
		//hitupdate(seq,hnum);
			
		String sql = "SELECT * FROM notices WHERE seq=" + seq;

		Connection con=DBCon.getConnection();
		// 실행
		Statement st = con.createStatement();
		// 결과
		ResultSet rs = st.executeQuery(sql);
		rs.next();

		// Notice에 select 결과물 담아보기
		Notice n = new Notice();
		n.setSeq(rs.getString("seq")); // DB에가 가져온 rs의 seq를 가져와서 Notice에 담기
		n.setWriter(rs.getString("writer"));
		n.setTitle(rs.getString("title"));
		n.setContent(rs.getString("content"));
		n.setRegdate(rs.getDate("regdate"));
		n.setHit(rs.getInt("hit"));
		n.setFilesrc(rs.getString("filesrc"));

		rs.close();
		st.close();
		con.close();

		return n; // n에 데이터를 다 입력받은 후 Notice타입인 n을 리턴
	}
	
}
