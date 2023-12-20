package 인터페이스;

import java.util.Random;

interface Repairable{}

interface Damageable{
	void damage(Damageable d);
}

class Unit {
	protected final int MAX_HP;
	protected int hp;
	protected String name;
	public Random rd = new Random();
	public Unit(int hp) {
		MAX_HP = hp;
		this.hp = hp;
	}

	@Override
	public String toString() {
		return "%s [%d / %d]".formatted(name, hp, MAX_HP);
	}
}

abstract class GroundUnit extends Unit {
	public GroundUnit(int hp) {
		super(hp);
	}
}

abstract class AirUnit extends Unit {
	public AirUnit(int hp) {
		super(hp);
	}
}

class Tank extends GroundUnit implements Repairable, Damageable{
	public Tank() {
		super(150);
		name = "Tank";
		System.out.println(this);
	}
	public void damage(Damageable units) {
		Unit unit = (Unit) units;
		int num = rd.nextInt(31) + 10;
		unit.hp -= num;
		System.out.println(this + "가 " + unit + "에게 " + num + "데미지");
	}
}

class Marine extends GroundUnit implements Damageable{
	public Marine() {
		super(50);
		name = "Marine";
		System.out.println(this);
	}
	public void damage(Damageable units) {
		Unit unit = (Unit) units;
		int num = rd.nextInt(31) + 10;
		unit.hp -= num;
		System.out.println(this + "가 " + unit + "에게 " + num + "데미지");
	}
}

class DropShip extends AirUnit implements Repairable, Damageable{
	public DropShip() {
		super(120);
		name = "DropShip";
		System.out.println(this);
	}
	public void damage(Damageable units) {
		Unit unit = (Unit) units;
		int num = rd.nextInt(31) + 10;
		unit.hp -= num;
		System.out.println(this + "가 " + unit + "에게 " + num + "데미지");
	}
}

class SCV extends GroundUnit implements Repairable, Damageable{
	public SCV() {
		super(60);
		name = "SCV";
		System.out.println(this);
	}
	public void repair(Repairable repairUnit) {
		Unit unit = (Unit) repairUnit;
		unit.hp += 30;
		if (unit.hp > unit.MAX_HP) {
			unit.hp = unit.MAX_HP;
			System.out.println(unit + "수리완료");
		} else {
			System.out.println(unit);
		}
	}
	public void damage(Damageable units) {
		Unit unit = (Unit) units;
		int num = rd.nextInt(31) + 10;
		unit.hp -= num;
		System.out.println(this + "가 " + unit + "에게 " + num + "데미지");
	}
}



public class _02인터페이스실습 {
	public static void main(String[] args) {
		
		Tank tank = new Tank();
		Marine marine = new Marine();
		DropShip dropship = new DropShip();
		SCV scv = new SCV();
		tank.damage(marine);
		marine.damage(scv);
		scv.damage(dropship);
		dropship.damage(tank);
		
		scv.repair(tank);
		System.out.println(marine);
		scv.repair(dropship);
		scv.repair(scv);
		
	}
}
