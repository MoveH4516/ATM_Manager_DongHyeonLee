package Zombie;


// 좀비는 히어로 공격 가능하고 한턴이 지날때마다 현재 체력의 50%를 회복하는 능력을 가지고 있다 
public class Zombie extends Unit {
	private int power;
	
	public Zombie(int pos,int hp,int max) {
		super(pos,hp,max);
	}
	
	public void setpower(int p) {
		this.power = p;
	}
	
	@Override
	public void attack(Unit unit) {
		Unit u = (Unit) unit;
		u.setHp(u.getHp() - power);
		int hp = getHp() + 5;
		this.setHp(hp);
		if (u.getHp() < 0) u.setHp(0);
		System.out.printf("좀비가 %d의 공격력으로 공격 현재 Hero HP : %d , 좀비 체력 회복 : %d%n", power, u.getHp(), getHp());
		if (u.getHp() == 0) {
			System.out.println("히어로 사망 게임 종료");
		}
	}
}