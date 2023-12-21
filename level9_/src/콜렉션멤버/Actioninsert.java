package 콜렉션멤버;

public class Actioninsert implements Action{
	
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		System.out.println("멤버 추가하기");
		System.out.println("아이디 입력");
		String id = Util.sc.next();
		if (!dao.isValidId(id)) {
			System.out.println("아이디 중복");
			return;
		}
		System.out.println("비밀번호 입력");
		String pw = Util.sc.next();
		dao.insertMember(new Member(id, pw));
	}
}
