package ATM;

import java.util.Arrays;

public class Client {

	int clientNo;
	String id;
	String pw;
	String name;
	Account[] accList;
	
	Client (int c, String id, String pw, String name) {
		this.clientNo = c;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	@Override
	public String toString() {
		String data = clientNo + "\t" + id + "\t" + pw + "\t" + name;
		if (accList != null) {
			data += "\n" + Arrays.toString(accList) + "\n";
		}
		return data;
	}

	String saveData() {
		return "%d/%s/%s/%s\n".formatted(clientNo, id, pw, name);
	}
	
}
