package Project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectService {
	Scanner scan = new Scanner(System.in);
	ProjectRepository pr = new ProjectRepository();

	public void save() {
		// 회원가입
		System.out.print("회원가입할 아이디 입력 : ");
		String id = scan.next();
		System.out.print("회원가입할 비밀번호 입력 : ");
		String password = scan.next();
		Boolean idCheck = pr.idCheck(id); // id중복 확인
		if (idCheck) {
			ProjectDTO pd = new ProjectDTO(id, password, 10l, 0l, 0l, 0l);
			pr.save(pd);
			System.out.println("가입에 성공하셨습니다.");
			System.out.println("회원가입 선물 : 칩 10개");
			System.out.println("아이디 : " + id + ", 비밀번호 : " + password + ", 칩 보유갯수 : 10개 ");
		} else {
			System.out.println("중복된 id 입니다!");
		}
	}

	public ProjectDTO login() {
		System.out.print("로그인할 아이디 입력 : ");
		String id = scan.next();
		System.out.print("로그인할 비밀번호 입력 : ");
		String password = scan.next();
		ProjectDTO login = pr.login(id, password);
		if (login != null) {
			System.out.println("로그인에 성공하셨습니다.");
		} else {
			System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다.");

		}
		return login;

	}

	public void findChip(String id) {
		Long findChip = pr.findChip(id);
		System.out.println("[" + id + "] 회원님이 보유하신 칩의 갯수는 " + findChip + "개 입니다.");

	}

	public void addChip(String id) {
		System.out.print("추가하실 칩의 갯수를 입력 해 주세요 : ");
		Long add = scan.nextLong();
		pr.addChip(id, add);
		System.out.println(add + "개 추가되었습니다.");
	}

	public void winRate(String id, Long long1, Long long2, Long long3) {
		System.out.println("[" + id + "] 회원님의 전적은 " + long1 + "승 " + long2 + "패 입니다. ");

	}

	public void game(ProjectDTO login) {
		pr.game(login);
	}

}
