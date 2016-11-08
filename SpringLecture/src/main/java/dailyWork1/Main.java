package dailyWork1;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Main {

	public static void main(String[] args) {

		//입력받은 Keyword를 이용해서 책의 제목과 저자를 출력하는데 만약 comment가 존재하면 같이 출력할 거에요!!
		
		
		System.out.println("키워드를 입력하세요 ==>");
		Scanner sc = new Scanner(System.in);
		String keyword = sc.nextLine(); //공백포함해서 받는당!
		
		//config 파일에 대한 경로를 문자열로 저장
		
		String config = "classpath:work_applicationCtx.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config); 
		BookService service = ctx.getBean("bookService",BookService.class);
		ArrayList<ArrayList<BookEntity>> list =  service.getListByKeyword(keyword);
		

		ArrayList<BookEntity> a = list.get(0);
		ArrayList<BookEntity> b = list.get(1);
		
		System.out.println(b.get(0).getBcomment()+"제발");
		System.out.println(b.get(1).getBcomment()+"제발");
		System.out.println(b.get(2).getBcomment()+"제발");

		
		for(int i=0;i<a.size();i++){
			System.out.println("책 제목 : "+a.get(i).getBtitle());
			System.out.println("책 저자 : "+a.get(i).getBauthor());
			
			for(int j=0;j<b.size();j++){
				if(a.get(i).getBisbn().equals(b.get(j).getBisbn())){
					System.out.println("책 comment : "+b.get(j).getBcomment());
				}
			}
		}
		
	/*	
		for(BookEntity entity :list){
			System.out.println("책 제목 : " +entity.getBtitle());
			System.out.println("책 저자 : " +entity.getBauthor());
			System.out.println("책 comment : " +entity.getBcomment());
		}
		
	
		*/
		sc.close();
		ctx.close();
	}
}
