package 상속;

abstract class Shape{
	abstract void draw();
}

class Line extends Shape{
	@Override
	void draw() {
		System.out.println("선 긋기");
	}
}

class Point extends Shape{
	@Override
	void draw() {
		System.out.println("점 찍기");
	}
}

class Circle extends Shape{
	@Override
	void draw() {
		System.out.println("원");
	}
}

class Rect extends Shape{
	@Override
	void draw() {
		System.out.println("사각형");
	}
}

class TriAngle extends Shape{
	@Override
	void draw() {
		System.out.println("삼각형");
	}
}

public class _07 {
	public static void main(String[] args) {
		
		// 모든 자식 클래스들이 draw 를 가지고 있기 때문에 사용하기가 매우 편하다.
		// 자식 클래스를 배열로 한 번에 묶어줄 수 있다.
		Shape[] list = {new Line(), new Point(),new Circle(), new Rect(), new TriAngle()};
		for (int i = 0; i < list.length; i++) {
			list[i].draw();
		}
		// 간편하게 여러 클래스를 사용 가능.
		double a = Math.PI * 12;
		System.out.printf("%.2f", a);
	}
}
