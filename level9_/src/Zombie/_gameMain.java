package Zombie;

import java.util.*;

public class _gameMain {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();

		Hero hero = new Hero(1, 200, 20, 2);
		Zombie zom = new Zombie(5, 100, 10);

		// pos,hp,max,shield
		Boss boss = new Boss(9, 300, 20, 100);

		int pos = 1;
		// hero.setPos(pos);
		while (true) {
			System.out.println("현재 위치 = " + pos);
			System.out.print("앞으로 이동하기(1),종료하기(2) ");
			int move = s.nextInt();
			if (move == 1) {
				hero.setPos(++pos);
				if (hero.getPos() == zom.getPos()) {
					System.out.print("좀비를 만났습니다. 공격모드로 바뀝니다. ");
					while (true) {
						System.out.print("공격하기(1),포션마시기(2): ");
						int d = s.nextInt();
						if (d == 1) {
							zom.setpower(r.nextInt(zom.getMax()) + 1);
							zom.attack(hero);
							hero.setpower(r.nextInt(hero.getMax()) + 1);
							hero.attack(zom);
						} else if (d == 2) {
							hero.heal();
						} else {
							continue;
						}
						if (zom.getHp() == 0 || hero.getHp() == 0) {
							break;
						}
					}
				}
				if (hero.getPos() == boss.getPos()) {
					System.out.print("보스를 만났습니다. 공격모드로 바뀝니다. ");
					while (true) {
						System.out.print("공격하기(1),포션마시기(2): ");
						int d = s.nextInt();
						if (d == 1) {
							boss.attack(hero);
							hero.attack(boss);
						} else if (d == 2) {
							hero.heal();
						} else {
							continue;
						}
						if (boss.getHp() == 0 || hero.getHp() == 0) {
							break;
						}
					}
				}
				if (hero.getPos() == 10) {
					System.out.println("게임에서 승리했습니다. 종료합니다.");
					break;
				}
			} else if (move == 2) {
				break;
			}
		}
		s.close();
	}
}
