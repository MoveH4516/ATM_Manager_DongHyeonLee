package Zombie;

// 유닛은 전부 이동가능하며 pos는 현재 위치를 나타낸다 
// 맵은 ~10까지 존재하며 한칸씩 이동 가능하다
// 유닛들은 전부 attack 메서드를 구현한다 

abstract public class Unit{
	private int pos; // 현재위치 
	private int hp; // 현재 hp
	private int max; // 랜덤 공격 1부터 max 까지의 범위 
	private boolean dead; // 죽었는지 살았는지 
	
	public Unit(int pos, int hp, int max) {
		this.pos=pos;
		this.hp=hp;
		this.max=max;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public boolean isDead() {
		return dead;
	}
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	abstract void attack(Unit unit);
}