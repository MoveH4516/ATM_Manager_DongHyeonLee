package 인터페이스;

// 추상클래스 vs 인터페이스
// 인터페이스 : 다중 상속이 목적.
// 클래스는 여러개 상속이 불가능하고 한 개만 상속이 가능하다.
// 반면에 인터페이스는 다중 상속이 가능하다. 따라서 다중 상속을 할 경우에 인터페이스를 사용한다.

abstract class A{
	void test1() {
		System.out.println("test1 호출");
	}
	abstract void test2();
}

class B extends A{
	int num = 10;
	void test2() {
		System.out.println("tset2 호출");
	}
}

interface E{
	int num = 20; // public static final int num 과 동일한 상황이다.
	void test3(); // public abstract void test3() 와 동일한 상황이다.
}

class C extends A implements E {
	public void test2() {
		System.out.println("test2");
	}
	public void test3() {
		System.out.println("test3");
	}
}

public class _01인터페이스이론 {
	public static void main(String[] args) {
		
		
		
	}
}
