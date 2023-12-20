package 상속;

class parent1{
	int a = 1;
	int b = 2;
}

class child1 extends parent1{
	int b = 5;
	int c = 10;
}

public class _06 {
	public static void main(String[] args) {
		// upcasting => 자식 객체가 부모클래스타입을 가지는 것.
		parent1 p = new parent1();
		
		child1 c1 = new child1();
		parent1 c2 = new child1(); // 이런 것이 가능.
		
		System.out.println(c1.a + " " + c1.b); 
		// child1 타입을 가진 자식클래스는 자신이 갖고 있는 변수가 우선시 된다.
		// super 를 사용하지 않는다면 parent1 의 b 를 가져올 수 없다.
		System.out.println(c2.a + " " + c2.b);
		// parent1 타입을 가진 자식 클래스는 평범하게 b 를 호출하면
		// parent1 클래스의 b 를 가져온다.
		System.out.println(p);
		
		
	}
}
