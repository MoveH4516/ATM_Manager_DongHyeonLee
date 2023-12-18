package ATM;

public class BankController {
	private ClientDAO cliDAO;
	private AccountDAO accDAO;
	
	public BankController() {
		cliDAO = new ClientDAO();
		accDAO = new AccountDAO();
		Util.laodFromFile(accDAO, cliDAO);
	}
	
	private void mainMenu() {
		System.out.println("[1]관리자 [2]사용자 [0]종료");
	}
	
	private void userMenu() {
		System.out.println("[1]회원가입 [2]로그인 [0]뒤로가기");
	}
	
	private void adminMenu() {
		System.out.println("[1]회원목록 [2]회원수정 [3]회원삭제 [4]데이터 저장 [5]데이터 불러오기");
	}
	
	private void loginMenu() {
		System.out.println("[1]계좌추가 [2]계좌삭제 [3]입금 [4]출금 [5]이체 [6]탈퇴 [7] 마이페이지 [0]로그아웃");
	}

	public void run() {
		while (true) {
			mainMenu();
			int sel = Util.getIntVal("메뉴선택", 0, 2);
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				while (true) {
					adminMenu();
					int num = Util.getIntVal("메뉴선택", 0, 5);
					if (num == 0) {
						break;
					} else if (num == 1) {
						cliDAO.print();
					} else if (num == 2) {
						cliDAO.editProfile();
					} else if (num == 3) {
						cliDAO.removeMember();
					} else if (num == 4) {
						Util.saveToFile(accDAO, cliDAO);
					} else if (num == 5) {
						Util.laodFromFile(accDAO, cliDAO);
					}
				}
			} else if (sel == 2) {
				while (true) {
					userMenu();
					int num = Util.getIntVal("메뉴선택", 0, 2);
					if (num == 0) {
						break;
					} else if (num == 1) {
						cliDAO.addClient();
					} else if (num == 2) {
						if (cliDAO.login() == -1) {
							break;
						} else {
							while (true) {
								loginMenu();
								int cho = Util.getIntVal("메뉴선택", 0, 7);
								if (cho == 0) {
									break;
								} else if (cho == 1) {
									if (cliDAO.addaccount()) {
										continue;
									}
									accDAO.addAcc(cliDAO.cList[cliDAO.log]);
									cliDAO.inputAccData(accDAO);
								} else if (cho == 2) {
									accDAO.deleteAcc(cliDAO.cList[cliDAO.log]);
									cliDAO.inputAccData(accDAO);
								} else if (cho == 3) {
									cliDAO.inputMoney();
								} else if (cho == 4) {
									cliDAO.outputMoney();
								} else if (cho == 5) {
									cliDAO.transMoney();
								} else if (cho == 6) {
									if (cliDAO.withdraw()) {
										break;
									}
								} else if (cho == 7) {
									cliDAO.printMyPage();
								}
							}
						}
					}
				}
			} else {
				continue;
			}
		}
	}
}
