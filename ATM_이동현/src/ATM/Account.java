package ATM;

public class Account {
// 한 회원마다 계좌 3개까지 만들 수 있다.
	String id;
	String accNumber;
	int money;
	
	Account (String id, String accNumber, int money) {
		this.id = id;
		this.accNumber = accNumber;
		this.money = money;
	}
	
	
	
	@Override
	public String toString() {
		String data = accNumber;
		return data;
	}
	
	String saveData() {
		return "%s/%s/%d\n".formatted(id,accNumber,money);
	}
	
	
}
