package dailyWork1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {


public ArrayList<ArrayList<BookEntity>> selectAll(String keyword){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookEntity> list = null;
		
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		ArrayList<BookEntity> list1 = null;
		ArrayList<ArrayList<BookEntity>> list2 = new ArrayList<ArrayList<BookEntity>>();

		
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
			list1 = new ArrayList<BookEntity>();

			while(rs.next()){
				BookEntity entity = new BookEntity();
				
				String bisbn =  rs.getString("bisbn");
				entity.setBisbn(bisbn);
			
				entity.setBtitle(rs.getString("btitle"));
				entity.setBauthor(rs.getString("bauthor"));
				
				
				String sql1 = "select * from books_comment where bisbn=?";
				pstmt1 = con.prepareStatement(sql1);
				pstmt1.setString(1, bisbn);
				rs1 = pstmt1.executeQuery();
				while(rs1.next()){
					BookEntity entity1 = new BookEntity();
					entity1.setBisbn(bisbn);
					entity1.setBcomment(rs1.getString("ctext"));
					list1.add(entity1);
				}
				
				list.add(entity);
				
			}
			
			list2.add(list);
			list2.add(list1);

			
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
		return list2;
	}

	
}
