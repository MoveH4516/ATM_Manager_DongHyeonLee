package 상속;

// 상속은 한 번만 가능하기 때문에 상속을 여러번 하기 위해서는 줄줄이 상속을 해야함.

class A2 {
	int a;
	A2() {
		System.out.println("호출1");
	}
}

class B2 extends A2{
	int b;
	B2() {
		System.out.println("호출2");
	}
}

class C2 extends B2{
	int c;
	C2() {
		System.out.println("호출3");
	}
}
public class _02 {
	public static void main(String[] args) {
		
		A2 a = new A2();
		B2 b = new B2();
		C2 c = new C2();
		// A가 실행되고, B 이전 부모클래스인 A 가 실행된 다음 B 실행
		// C 이전 부모클래스인 B 이전 부모클래스인 A 가 실행된 다음 B 가 실행된 다음 C 실행.
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
