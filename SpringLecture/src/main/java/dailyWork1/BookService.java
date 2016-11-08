package dailyWork1;

import java.util.ArrayList;

public class BookService {

	private BookDAO dao;
	
	
	public BookService(){
		//default constructor는 무조건 만들어 주는게 좋아욤!
	}

	public BookService(BookDAO dao){
		this.dao = dao;
	}
	
	public BookDAO getDao() {
		return dao;
	}	

	public void setDao(BookDAO dao) {
		this.dao = dao;
	}
	
	/*public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}*/
	
	public ArrayList<ArrayList<BookEntity>> getListByKeyword(String keyword){
		//DAO생성
		//DAOmethod 호출 => 결과 받아서 return	
		return dao.selectAll(keyword);
	}
}
