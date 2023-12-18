package ATM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Util {
	Scanner sc= new Scanner(System.in);;
	final String CUR_PATH = System.getProperty("user.dir") + "\\src\\ATM\\";
	
	int getIntVal(String msg, int start, int end) {
		while (true) {
			System.out.printf("▶ %s[%d-%d] 입력:", msg, start, end);
			try {
				int num = sc.nextInt();
				sc.nextLine();
				if (num < start || num > end) {
					System.out.printf("%d - %d 사이값 입력해주세요 %n", start, end);
					continue;
				}
				return num;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("숫자값을 입력하세요");
			}
		}
	}
	
	String getStrVal(String msg) {
		System.out.printf("▶ %s 입력:", msg);
		return sc.next();
	}
	
	void fileInit(String fileName) {
		File file = new File(CUR_PATH + fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("파일 생성 실패");
				e.printStackTrace();
			}
		}
	}
	
	String loadData (String fileName) {
		String data = "";
		try (FileReader fr = new FileReader(CUR_PATH + fileName);
				BufferedReader br = new BufferedReader(fr)) {
			while (true) {
				String s = br.readLine();
				if (s == null) {
					break;
				}
				data += s + "\n";
			}
			data = data.substring(0, data.length() - 1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	void laodFromFile(AccountDAO accDAO, ClientDAO cliDAO) {
		String accData = loadData("account.txt");
		String cliData = loadData("client.txt");
		
		accDAO.init(accData);
		cliDAO.init(cliData);
		cliDAO.inputAccData(accDAO); 
		cliDAO.updateMaxNum();
	}
	
	void saveToFile (AccountDAO accDAO, ClientDAO cliDAO) {
		String accData = accDAO.saveFile();
		String cliData = cliDAO.saveFile();
		
		saveData("account.txt", accData);
		saveData("client.txt", cliData);
	}
	
	void saveData(String fileName, String data) {
		try(FileWriter fw = new FileWriter(CUR_PATH + fileName)) {
			fw.write(data);
			System.out.println("저장");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("실패");
		}
	}
	
	
}
