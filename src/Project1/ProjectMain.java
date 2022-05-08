package Project1;

import java.util.Scanner;

public class ProjectMain {

	public static void main(String[] args) {
		// 1.(메뉴) a.회원가입 , b.로그인 , c.종료 2.(로비) c.로그아웃(메뉴로 돌아옴) , a.칩 갯수 확인 , b.칩 추가 ,
		// 3.게임플레이 a.게임진행 b.로비로 이동
		// 인게임 : 3장받고 4장깔기 : 3장받고 바닥에 1개깔리고 1장공개 -> 배팅(칩+1개) -> 1장깔고 1장받고 -> 배팅(칩+1개) -> 1장깔고 마지막배팅(칩+2개) -> 결과
		// 배팅 x시 칩증발 상대는 다이x

		Scanner scan = new Scanner(System.in);
		ProjectService ps = new ProjectService();
		boolean check = true;
		do {
			System.out.println("메뉴");
			System.out.println("----------------------------");
			System.out.println("1.회원가입 || 2.로그인 || 3.종료");
			System.out.println("----------------------------");
			System.out.print("입력 > ");
			int choice = scan.nextInt();
			if (choice == 1) {
				ps.save(); // 회원가입
			} else if (choice == 2) {
				boolean check2 = true;
				ProjectDTO login = ps.login(); // 로그인
				if (login != null) {
					do {
						System.out.println("로비");
						System.out.println(
								"----------------------------------------------------------------------------------");
						System.out.println("1.게임대기실 입장 || 2.칩 갯수 확인 || 3.칩 추가 || 4.전적 확인 || 5.로그아웃 || 6.프로그램 종료");
						System.out.println(
								"-----------------------------------------------------------------------------------");
						System.out.print("입력 > ");
						int choice2 = scan.nextInt();
						if (choice2 == 1) {
							boolean check3 = true;
							System.out.println("[" + login.getId() + "] 님 환영합니다.");
							do {
								System.out.println("대기실");
								System.out.println("---------------------------------------");
								System.out.println("1.게임시작 || 2.로비로 이동 || 3.프로그램 종료");
								System.out.println("---------------------------------------");
								System.out.print("입력 > ");
								int choice3 = scan.nextInt();
								if (choice3 == 1) {
									ps.game(login);
								} else if (choice3 == 2) {
									System.out.println("로비로 이동합니다.");
									check3 = false;
								} else if (choice3 == 3) {
									System.out.println("프로그램을 종료합니다.");
									check = false;
									check2 = false;
									check3 = false;
								} else {
									System.out.println("올바른 숫자를 입력해 주세요.");
								}
							} while (check3);
						} else if (choice2 == 2) {
							ps.findChip(login.getId()); // 칩 조회
						} else if (choice2 == 3) {
							ps.addChip(login.getId()); // 칩 추가
						} else if (choice2 == 4) {
							ps.winRate(login.getId(), login.getWin(), login.getLose(), login.getWinRate()); // 승률 조회
						} else if (choice2 == 5) {
							System.out.println("로그아웃 합니다.");
							check2 = false;
						} else if (choice2 == 6) {
							check = false;
							System.out.println("프로그램을 종료합니다.");
							break;
						} else {
							System.out.println("올바른 숫자를 입력해 주세요.");
						}
					} while (check2);
				}
			} else if (choice == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			System.out.println();
		} while (check);

	}

}
