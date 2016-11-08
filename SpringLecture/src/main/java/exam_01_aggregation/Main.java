package exam_01_aggregation;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//입력받고
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 키워드 : ");
		String keyword = sc.nextLine();
		
		System.out.println("입력된 값은 : " +keyword);
		
		//로직 처리하고
		//로직처리를 위한 service객체를 생성
		//나중에 DB처리를 위해서 DAO객체를 생성
		BookDAO dao = new BookDAO();
		BookService service = new BookService(dao);
		
		
		//출력처리
		service.getListByKeyword(keyword);
		
		
		//서비스를 이용해서 business logic을 수행
		ArrayList<BookEntity> list = service.getListByKeyword(keyword);
		
		for(BookEntity entity :list){
			System.out.println(entity.getBtitle()+" : "+ entity.getBauthor());
		}
		
		//사용한 resource 해제
		sc.close();
		
	}
}
