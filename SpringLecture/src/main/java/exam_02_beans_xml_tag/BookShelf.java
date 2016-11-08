package exam_02_beans_xml_tag;

import java.util.ArrayList;
import java.util.Map;

public class BookShelf {

	private String shelfName; //책장명
	private int shelfPrice;   //책장 가격
	private ArrayList<BookEntity> list; // arrayList로 되어 있는 책을
	private Map<Integer,BookEntity> map; //map으로 되어 있는 책들
	
	public BookShelf(){
		
	}
	
	public BookShelf(int shelfPrice, ArrayList<BookEntity> list){
		this.shelfPrice = shelfPrice;
		this.list = list;
	}
	
	public String getShelfName() {
		return shelfName;
	}

	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}

	public int getShelfPrice() {
		return shelfPrice;
	}

	public void setShelfPrice(int shelfPrice) {
		this.shelfPrice = shelfPrice;
	}

	public ArrayList<BookEntity> getList() {
		return list;
	}

	public void setList(ArrayList<BookEntity> list) {
		this.list = list;
	}

	public Map<Integer, BookEntity> getMap() {
		return map;
	}

	public void setMap(Map<Integer, BookEntity> map) {
		this.map = map;
	}


}
