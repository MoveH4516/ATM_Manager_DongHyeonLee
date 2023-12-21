package 콜렉션멤버;

public class Actionchange implements Action{
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		if (dao.check()) return;
		System.out.println("아이디 입력");
		String id = Util.sc.next();
		System.out.println("비밀번호 입력");
		String pw = Util.sc.next();
		int idx = dao.isValidLogin(id, pw);
		if (idx == -1) {
			System.out.println("회원정보가 일치하지 않습니다.");
			return;
		}
		System.out.println("새로운 비밀번호 입력");
		String newPw = Util.sc.next();
		dao.changePw(id, newPw, idx);
	}
}
