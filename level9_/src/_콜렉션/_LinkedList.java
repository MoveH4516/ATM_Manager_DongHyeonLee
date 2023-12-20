package _콜렉션;

import java.util.*;

public class _LinkedList {
	public static void main(String[] args) {
		
		List<Integer> list = new LinkedList<Integer>();
		// 앞부분을 List 로 해서 Array Linked Vector 로 자유롭게 변경할 수 있다.
		list.add(10);
		list.add(20);
		list.add(30);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		Collections.sort(list);
		System.out.println(list);
		
	}
}
