package 콜렉션멤버;

import java.util.ArrayList;

public class MemberDAO {
	private MemberDAO() {
		init();
	}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private ArrayList<Member> memberList;
	private void init() {
		memberList = new ArrayList<Member>();
	}
	
	public void insertMember(Member member) {
		memberList.add(member);
		System.out.println(member + "추가 완료");
	}
	
	public void deleteMember (int idx) {
		memberList.remove(idx);
		System.out.println("삭제 완료");
	}
	
	public boolean check() {
		if (memberList.size() == 0) {
			System.out.println("회원 정보가 없습니다.");
			return true;
		}
		return false;
	}
	
	public void changePw(String id, String pw, int idx) {
		memberList.set(idx, new Member(id, pw));
		System.out.println("회원 정보 수정 완료");
		System.out.println("새로운 비밀번호 : " + pw);
	}
	
	public void printMember() {
		for (int i = 0; i < memberList.size(); i++) {
			System.out.println(memberList.get(i));
		}
	}
	
	public int isValidLogin(String id, String pw) {
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().equals(id) && memberList.get(i).getPw().equals(pw)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean isValidId(String id) {
		if (memberList.size() == 0) return true;
		for (Member member : memberList) {
			if (member.getId().equals(id)) {
				return false;
			}
		}
		return true;
	}
	
}
