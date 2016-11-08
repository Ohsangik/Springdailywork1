package hahaha;

public class Person {
	
	//1.변수 => 필드
	//2.함수 =>method
	//3.생성자 => 만들어진 instance를 초기화 시켜주는 역할
	
	private int age; //객체지향 개념중 information hiding이라는 개념을 java언어에서 access modifier인 private으로 구현
					//단, 외부에서 해당 field를 제어하기 위해 getter or setter를 구현

	
	public Person() {
	
	}

	
	public int getAge() {
		return age;
	}

	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
}
