package 상속;

class A1{
	int a;
	int b;
}

class B1{
	A1 a = new A1();
	int c;
	int d;
}
// 상속은 자식 클래스가 extends + 부모클래스 이름 의 형태이다.
class C1 extends A1{ 
	int e;
	int f;
}
// 자식 클래스.
// 1. 부모 클래스의 필드나 메서드에 접근 가능
// 2. 상속은 단 한 번만 허용.

public class _01 {
	public static void main(String[] args) {
		
		// 객체지향(OOP) : Object oriented programming
		// 여러 객체들이 상호 협력하여 task 를 수행 완료 시키는 것.
		// ex) 영화를 예매 (task) = > 스크린, 영화관, 좌석, 티켓 등등 객체 사용
		
		
		
	}
}
