package 콜렉션멤버;

public class Actiondelete implements Action{
	
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		if (dao.check()) return;
		System.out.println("멤버 삭제하기");
		System.out.println("삭제할 아이디");
		String id = Util.sc.next();
		if (dao.isValidId(id)) {
			System.out.println("일치하는 아이디가 없습니다.");
			return;
		}
		System.out.println("비밀번호 입력");
		String pw = Util.sc.next();
		int idx = dao.isValidLogin(id, pw);
		if (idx == -1) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		dao.deleteMember(idx);
	}
}
