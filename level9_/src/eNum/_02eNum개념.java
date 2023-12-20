package eNum;

enum week{
	mon,two,wen
}

class Button{
	enum Mode {LIGTH,DARK}
	enum Space {SINGLE,DOOUBLE}
	// 클래스 안에서 배열처럼 만드는 것도 가능.
	
	private Mode mode = Mode.LIGTH;
	private Space space = Space.SINGLE;
	
	public void switchMode() {
		mode = mode == Mode.LIGTH ? Mode.DARK : Mode.LIGTH;
	}
	public Space getSpace() {
		return space;
	}
	public Mode getMode() {
		return mode;
	}
}

public class _02eNum개념 {
	public static void main(String[] args) {
		
		week w = week.mon;
		System.out.println(w);
		// 클래스처럼 만드는 것도 가능.
		
		Button b = new Button();
		System.out.println(b.getMode());
		b.switchMode();
		System.out.println(b.getMode());
		System.out.println(b.getSpace());
		
		
		
		
	}
}
