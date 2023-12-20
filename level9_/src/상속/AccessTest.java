package 상속;

public class AccessTest {
	public int a;
	protected int b; // 동일한 패키지 안에 있는 자기 객체와 자식 객체만 접근 가능
	private int c; // 본인 클래스 에서만 접근 가능
	int d; // 같은 패키지 에서만 가능
	
	void printC() {
		c = 1000;
		System.out.println(c);
	}
}
