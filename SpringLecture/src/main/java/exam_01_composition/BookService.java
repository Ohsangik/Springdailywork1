package exam_01_composition;

import java.util.ArrayList;

public class BookService {

	//Business Logic을 처리하는 method
	public ArrayList<BookEntity> getListByKeyword(String keyword){
		//로직처리가 나와요!!
		//DB처리가 나와요!!
		
		BookDAO dao = new BookDAO();
		ArrayList<BookEntity> list = dao.selectAll(keyword);
		
		return list;
		
	}
}


