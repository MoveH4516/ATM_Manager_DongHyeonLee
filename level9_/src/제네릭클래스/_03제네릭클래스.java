package 제네릭클래스;

import game.*;

public class _03제네릭클래스 {
	public static void main(String[] args) {
		
		Horse<Unit> horse1 = new Horse<Unit>(30);
		System.out.println(horse1);
		
		horse1.setRider(new Knight());
		
		// 자신을 포함한 자식 클래스만 가능 or 자신을 포함한 부모 클래스만 가능
		// extends / super 
		// ex
		Horse<? extends Knight> horse2;
		// horse2 = hores1; -> horse1 은 Unit 으로 부모클래스이기 때문에 불가능
		Horse<Knight> horse3 = new Horse<Knight>();
		horse2 = horse3;
		// horse3 는 Knight 로 자신을 포함하기 때문에 가능
		System.out.println(horse2);
	}
}
