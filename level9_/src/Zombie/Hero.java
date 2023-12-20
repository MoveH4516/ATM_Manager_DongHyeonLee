package Zombie;

// 보스인지 아닌지 구분해서 공격 

// 히어로는 체력 포션으로 100 체력 회복할 수 있고 체력 포션이 없으면 체력 회복이 안된다 
// 외부의 적은 보스인지 아닌지 구별해서 공격 해야한다 
// 보스이면 보호막을 가지고 있다 먼저 보호막을 다 뚫어야지만 직접 보스를 공격할 수 있다. 
// 일반 적은 보호막 가지고 있지 않음 

public class Hero extends Unit {
	private int power;
	private int count;
	
	public Hero(int pos, int hp, int max, int count) {
		super(pos, hp, max);
		this.count = count;
	}
	
	public void setpower(int p) {
		this.power = p;
	}
	
	@Override
	public void attack(Unit unit) {
		if(unit instanceof Zombie) {
			Unit u = (Unit) unit;
			u.setHp(u.getHp() - power);
			if (u.getHp() <= 0) {
				u.setHp(0);
			}
			System.out.printf("히어로가 %d의 공격력으로 공격 현재 좀비의 HP : %d%n", power, u.getHp());
			if (u.getHp() == 0) {
				System.out.println("좀비 처치");
			}
		} else if (unit instanceof Boss) {
			Boss b = (Boss) unit;
			if (b.getShield() > 0) {
				b.setShield(b.getShield() - power);
				if (b.getShield() < 0) b.setShield(0);
			} else {
				b.setHp(b.getHp() - power);
			}
		}
	}
	
	public void heal() {
		if (count == 0) {
			System.out.println("포션이 없습니다.");
			return;
		}
		count--;
		this.setHp(this.getHp() + 100);
		System.out.println("체력을 회복해서 " + this.getHp() + "(이)가 되었습니다. 남은 포션 : " + count);
	}

}