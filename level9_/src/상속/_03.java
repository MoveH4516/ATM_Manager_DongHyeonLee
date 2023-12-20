package 상속;

class Parent{
	void test1() {
		System.out.println("부모 test1 호출");
	}
}

class Child extends Parent{
	void test2() {
		System.out.println("test2 호출");
	}
	void test1() { // 부모클래스에 있는 같은 이름의 메서드를 자식 클래스로 재정의 (오버라이딩)
		System.out.println("자식 test1 호출"); // toString 이라고 생각하면 된다.
		super.test1();
	}
}

public class _03 {
	public static void main(String[] args) {
		
		Child c= new Child();
		// 원래라면 Parent 에 있는 test1 이 나와야 하지만 오버라이딩으로 인해
		// Child 의 test1이 호출된다.
		// 만약 부모클래스를 가져오고 싶다면 super() 를 해줘야 한다.
		c.test1(); 
		c.test2();
		
	}
}
