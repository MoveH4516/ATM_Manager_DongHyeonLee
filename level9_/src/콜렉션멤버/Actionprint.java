package 콜렉션멤버;

public class Actionprint implements Action{
	public void excute() {
		MemberDAO dao = MemberDAO.getInstance();
		if (dao.check()) return;
		dao.printMember();
	}
}
