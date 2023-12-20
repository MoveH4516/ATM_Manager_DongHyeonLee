package test;

import 상속.AccessTest;

class child extends AccessTest{
	child() {
		super.a = 10;
		b = 100;
		// 클래스가 다른 c는 불가능
		// 패키지가 다른 d는 불가
		System.out.println(b);
	}
	
}

public class _Main {
	public static void main(String[] args) {
		
		child c = new child();
		c.a = 100;
		System.out.println(c.a);
		// b 는 같은 패키지가 아니기 때문에 사용 불가
		// b 를 사용하고 싶다면 자식 클래스 안에서 사용
	}
}
