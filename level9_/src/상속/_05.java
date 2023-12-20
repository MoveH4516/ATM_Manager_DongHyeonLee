package 상속;

// abstract // 추상화 : <-> 구체화
// 클래스를 설계 : 상태(data) 행동(method)

// 추상 클래스는 구체적이지 않기 때문에 행동이 빠져있다.
// 추상 메서드의 구현체 {}가 빠져있다.

// 단 하나라도 추상메서드를 가지고 있다면 추상클레스 이다.

abstract class A3{
	int num = 10;
	abstract void test1(); // 구현부인 {} 가 빠져있어 앞에 abstract 키워드가 있다.
	
	void test2() {
		System.out.println("test2 호출 " + num);
	}
}

class B3 extends A3{
	// 추상메서드를 자식클래스가 오버라이딩을 통해 완성된 메서드를 만들어 주어야 한다.
	@Override
	void test1() {
		System.out.println("test1 추상클래스 호출");
	}
	
}

public class _05 {
	public static void main(String[] args) {
		
		// A3 a = new A3(); -> 불완전한 클래스 이므로 객체를 만들 수 없다.
		B3 b = new B3();
		b.test1();
		b.test2();
	}
}
