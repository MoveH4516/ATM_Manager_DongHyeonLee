package ATM;

public class AccountDAO {
	
	Util sc;
	Account[] accList;
	int cnt;
	
	AccountDAO() {
		sc = new Util();
	}
	
	void init(String data) {
		String[] temp = data.split("\n");
		cnt = temp.length;
		accList = new Account[cnt];
		for (int i = 0; i < cnt; i++) {
			String[] arr = temp[i].split("/");
			accList[i] = new Account(arr[0], arr[1], Integer.parseInt(arr[2]));
		}
	}
	
	String saveFile() {
		if (cnt == 0) return "";
		String data = "";
		for (Account a : accList) {
			data += a.saveData();
		}
		return data;
	}
	
	boolean checkAcc(String acc) {
		if (acc.length() != 14) {
			return true;
		}
		
		return false;
	}
	
	void addAcc (Client c) {
		String acc = sc.getStrVal("계좌 입력 : ");
		Account account = findacc(c, acc);
		if (account != null) {
			System.out.println("계좌번호 중복");
			return;
		}
		if (checkAcc(acc)) {
			System.out.println("계좌번호 오류");
			return;
		}
		if (cnt == 0) accList = new Account[1];
		else {
			Account[] temp = accList;
			accList = new Account[cnt + 1];
			for (int i = 0; i < cnt; i++) {
				accList[i] = temp[i];
			}
		}
		System.out.println("계좌 추가 완료");
		accList[cnt] = new Account(c.id, acc, 1000);
		cnt++;
	}
	
	Account findacc (Client c, String acc) {
		if (c.accList == null) return null;
		for (Account a : c.accList) {
			if (acc.equals(a.accNumber)) {
				return a;
			}
		}
		return null;
	}
	
	void deleteAcc (Client c) {
		String acc = sc.getStrVal("계좌 입력 : ");
		Account account = findacc(c, acc);
		if (account == null) {
			System.out.println("계좌번호 불일치");
			return;
		}
		int idx = 0;
		for (int i = 0; i < cnt; i++) {
			if (accList[i].accNumber.equals(account.accNumber)) {
				idx = i;
				break;
			}
		}
		if (cnt == 1) accList = null;
		else {
			int index = 0;
			Account[] temp = accList;
			accList = new Account[cnt - 1];
			for (int i = 0; i < cnt; i++) {
				if (idx != i) {
				accList[index++] = temp[i];
				}
			}
			cnt--;
		}
	}
	Account[] getAccFromClient(Client c) {
		int cnt = 0;
		for (Account a : accList) {
			if (c.id.equals(a.id)) {
				cnt++;
			}
		}
		if (cnt == 0) return null;
		Account[] list = new Account[cnt];
		int idx = 0;
		for (Account a : accList) {
			if (c.id.equals(a.id)) {
				list[idx++] = a;
			}
		}
		return list;
	}
	
	
	
}
