package exam_01_composition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {

	public ArrayList<BookEntity> selectAll(String keyword){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookEntity> list = null;
		
		try {
			
			//1. Driver Loading
			Class.forName("com.mysql.jdbc.Driver");
			//2. 데이터베이스 접속
		    String url ="jdbc:mysql://localhost:3306/library";
			String id = "jQuery";
			String pw = "jQuery";
			
			con = DriverManager.getConnection(url,id,pw);
			
			//3.PreparedStatement 생성
			
			String sql = "select bisbn,btitle,bauthor from book where btitle like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			
			//4.Query 실행
			
			rs = pstmt.executeQuery();
			
			//5.결과처리
			//database에서 들고온 데이터를 ArrayList<BookEntity>
			list = new ArrayList<BookEntity>();
			
			while(rs.next()){
				BookEntity entity = new BookEntity();
				entity.setBisbn(rs.getString("bisbn"));
				entity.setBtitle(rs.getString("btitle"));
				entity.setBauthor(rs.getString("btitle"));
				list.add(entity);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}





