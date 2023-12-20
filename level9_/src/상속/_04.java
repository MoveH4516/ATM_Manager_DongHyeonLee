package 상속;

// 접근제어자 종류

public class _04 {
	public static void main(String[] args) {
		
		AccessTest at = new AccessTest();
		at.a = 10;
		at.b = 20;
		at.d = 30;
		at.printC();
		// 클래스가 다른 c는 불가능
	}
}
