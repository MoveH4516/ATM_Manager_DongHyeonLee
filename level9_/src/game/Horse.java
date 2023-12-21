package game;

public class Horse<T extends Unit> {
    private int extraHp;
    private T rider;

    public Horse(int extraHp) {
        this.extraHp = extraHp;
    }

    public Horse() {
    	
	}

	public void setRider(T rider) {
		this.rider = rider;
    	System.out.printf("%s가 말에 올라탔다 " , this.rider);
        rider.hp += extraHp;
        System.out.println(this);
    }

		@Override
    public String toString() {
        return "말 (추가체력: %d)".formatted(extraHp);
    }
}