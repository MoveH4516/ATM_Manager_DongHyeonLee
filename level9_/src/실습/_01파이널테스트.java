package 실습;

class Test{
	int num1;
	int num2;
	public Test(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	@Override
	public String toString() {
		return "num1 " + num1 + " num2 " + num2;
	}
}

public class _01파이널테스트 {
	public static void main(String[] args) {
		
		final int a = 10;
		final int b = 20;
		Test t = new Test(a, b);
		System.out.println(t);
		
	}
}
