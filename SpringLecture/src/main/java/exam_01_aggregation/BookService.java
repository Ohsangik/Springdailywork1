package exam_01_aggregation;

import java.util.ArrayList;

public class BookService {
	
	private DAO dao;
	
	public BookService(BookDAO dao){
		this.dao = dao;
	}
	
	
	//Business Logic을 처리하는 method
	public ArrayList<BookEntity> getListByKeyword(String keyword){

		//로직처리가 나와요!!
		//DB처리가 나와요!!
		ArrayList<BookEntity> list = dao.selectAll(keyword);
		
		return list;
		
	}
}


