package 제네릭클래스;

class Box<T>{
	private T t;
	public T getT() {
		return t;
	}
	public void setNum(T t) {
		this.t = t;
	}
}

public class _01제네릭클래스이론1 {
	public static void main(String[] args) {
		
		Box<Integer> boxT = new Box<Integer>();
		boxT.setNum(10);
		System.out.println(boxT.getT());
	}
}
