package ATM;

public class ClientDAO {
	Util sc;
	Client[] cList;
	
	int maxNum;
	int cnt;
	int log = -1;
	
	ClientDAO() {
		sc = new Util();
		maxNum = 1001;
	}
	
	void init(String data) {
		String[] temp = data.split("\n");
		cnt = temp.length;
		cList = new Client[cnt];
		for (int i = 0; i < cnt; i++) {
			String[] arr = temp[i].split("/");
			cList[i] = new Client(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3]);
		}
	}
	
	boolean hasData() {
		if (cList == null) {
			System.out.println("데이터 없음");
			return false;
		}
		return true;
	}
	
	void addClient() {
		if (cnt == 0) {
			cList = new Client[1];
		} 
		String id = sc.getStrVal("아이디");
		int idx = -1;
		for (int i = 0; i < cList.length; i++) {
			if (id.equals(cList[i].id)) {
				idx = i;
				break;
			}
		}
		if (idx != -1) {
			System.out.println("중복된 아이디");
			return;
		}
		String pw = sc.getStrVal("비밀번호");
		String name = sc.getStrVal("이름");
//		String acc = sc.getStrVal("계좌번호");
//		if (acc.length() != 14) {
//			System.out.println("계좌번호 오류");
//			return;
//		}
//		for (int j = 0; j < cList.length; j++) {
//			if (cList[j].accList != null) {
//				for (int i = 0; i < cList[j].accList.length; i++) {
//					if (cList[j].accList[i].accNumber.equals(acc)) {
//						System.out.println("계좌번호 중복");
//						return;
//					}
//				}
//			}
//		}
		Client[] temp = cList;
		cList = new Client[cnt + 1];
		for (int i = 0; i < cnt; i++) {
			cList[i] = temp[i];
		}
		cList[cnt] = new Client(++maxNum, id, pw, name);
		System.out.println(cList[cnt].id);
		System.out.println("회원가입 완료");
		cnt++;
	}
	
	int login() {
		String id = sc.getStrVal("ID");
		String pw = sc.getStrVal("PW");
		for (int i = 0; i < cnt; i++) {
			if (id.equals(cList[i].id) && pw.equals(cList[i].pw)) {
				System.out.println("로그인 성공");
				log = i;
				return i;
			}
		}
		System.out.println("로그인 실패");
		return -1;
	}
	
	void inputAccData(AccountDAO accDAO) {
		if (!hasData()) return;
		for (int i = 0; i < cnt; i++) {
			cList[i].accList = accDAO.getAccFromClient(cList[i]);
		}
	}
	
	void updateMaxNum() {
		if(cnt == 0) return;
		int maxNo = 0;
		for(Client c : cList) {
			if(maxNo < c.clientNo) {
				maxNo = c.clientNo;
			}
		}
		this.maxNum = maxNo;
	}
	
	int checkAcc() {
		String acc = sc.getStrVal("계좌");
		for (int i = 0; i < cList[log].accList.length; i++) {
			if (cList[log].accList[i].accNumber.equals(acc)) {
				return i;
			}
		}
		return -1;
	}
	
	void inputMoney() {		
		int num = checkAcc();
		if (num == -1) {
			System.out.println("계좌번호가 틀렸습니다.");
			return;
		}
		int money = sc.getIntVal("입금 금액 (한도 100만원)", 0, 1000000);
		cList[log].accList[num].money += money;
	}
	
	void transMoney() {
		if (cList[log].accList == null) {
			System.out.println("등록된 계좌가 없습니다.");
			return;
		}
		int num = -1;
		if (cList[log].accList.length != 1) {
			num = checkAcc();
		} else {
			num = 0;
		}
		if (num == -1) {
			System.out.println("계좌번호가 틀렸습니다.");
			return;
		}
		int idx1 = -1;
		int idx2 = -1;
		System.out.println("보낼 계좌");
		String acc = sc.getStrVal("계좌");
		for (int i = 0; i < cnt; i++) {
			if (cList[i].accList != null) {
				for (int j = 0; j < cList[i].accList.length; j++) {
					if (cList[i].accList[j].accNumber.equals(acc) && i != log) {
						idx1 = i;
						idx2 = j;
					}
				}
			}
		}
		if (idx2 == -1) {
			System.out.println("계좌번호가 틀렸습니다.");
			return;
		}
		
		int money = sc.getIntVal("입금할 금액 : ", 0, cList[log].accList[num].money);
		cList[log].accList[num].money -= money;
		cList[idx1].accList[idx2].money += money;				
	}
	
	void outputMoney() {
		int num = checkAcc();
		if (num == -1) {
			System.out.println("계좌번호가 틀렸습니다.");
			return;
		}
		int money = sc.getIntVal("출금할 금액 : ", 0, cList[log].accList[num].money);
		cList[log].accList[num].money -= money;
	}
	
	String saveFile() {
		if (cnt == 0) return "";
		String data = "";
		for (Client a : cList) {
			data += a.saveData();
		}
		return data;
	}
	
	boolean addaccount() {
		if (cList[log].accList == null) return false;
		if (cList[log].accList.length == 3) {
			System.out.println("계좌 추가 불가능");
			return true;
		}
		return false;
//		String acc = sc.getStrVal("계좌번호");
//		if (acc.length() != 14) {
//			System.out.println("계좌번호 오류");
//			return;
//		}
//		for (int j = 0; j < cList.length; j++) {
//			if (cList[j].accList != null) {
//				for (int i = 0; i < cList[j].accList.length; i++) {
//					if (cList[j].accList[i].accNumber.equals(acc)) {
//						System.out.println("계좌번호 중복");
//						return;
//					}
//				}
//			}
//		}
	}
	
	void print() {
		for (int i = 0; i < cnt; i++) {
			System.out.println(cList[i].clientNo + " " + cList[i].id + " " + cList[i].pw + " " + cList[i].name);
			if (cList[i].accList == null) System.out.println("계좌가 없습니다.");
			else {
			for (int j = 0; j < cList[i].accList.length; j++) {
				System.out.println(cList[i].accList[j].accNumber);
			}
			}
			System.out.println();
		}
	}
	
	int checkID() {
		String id = sc.getStrVal("아이디 검색 : ");
		for (int i = 0; i < cnt; i++) {
			if (id.equals(cList[i].id)) {
				return i;
			}
		}
		return -1;
	}
	
	void editProfile() {
		int num = checkID();
		if (num == -1) {
			System.out.println("해당 아이디 없음.");
			return;
		}
		int sel = sc.getIntVal("[1]비밀번호 변경 [2]이름 변경", 1, 2);
		if (sel == 1) {
			String pw = sc.getStrVal("변경할 비밀번호");
			cList[num].pw = pw;
		} else {
			String name = sc.getStrVal("변경할 이름");
			cList[num].name = name;
		}
	}
	
	void removeMember() {
		int num = checkID();
		if (num == -1) {
			System.out.println("해당 아이디 없음.");
			return;
		}
		System.out.println(cList[num].id + "를 정말 삭제하시겠습니까?");
		int sel = sc.getIntVal("[1]예 [2]아니오", 1, 2);
		if (sel == 1) {
			for (int i = num; i < cnt - 1; i++) {
				cList[i] = cList[i + 1];
			}
			cList[--cnt] = null;
		} else {
			return;
		}
	}
	
	void printMyPage() {
		System.out.printf("%s\n", cList[log]);
	}
	
	boolean withdraw() {
		int sel = sc.getIntVal("정말 탈퇴하시겠습니까? [1]예 [2]아니오", 1, 2);
		if (sel == 1) {
			int idx = 0;
			Client[] temp = cList;
			cList = new Client[cnt - 1];
			for (int i = 0; i < cnt; i++) {
				if (i != log) {
					cList[idx++] = temp[i];
				}
			}
			System.out.println("탈퇴 완료");
			cnt--;
			return true;
		} else {
			return false;
		}
	}
	
}
