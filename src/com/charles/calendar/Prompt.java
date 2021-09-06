package com.charles.calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	public void printMenu() {
		System.out.println("+-------------------+");
		System.out.println("|    1. 일정 등록   |");
		System.out.println("|    2. 일정 검색   |");
		System.out.println("|    3. 달력 보기   |");
		System.out.println("| h. 도움말 q. 종료 |");
		System.out.println("+-------------------+");
	}

	public void runPrompt() throws ParseException {
		printMenu();
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		while (true) {
			System.out.println("입력하세요(1, 2, 3, h, q)");
			String cmd = scanner.next();
			if (cmd.equals("1")) {
				cmdRegister(scanner, cal);
			} else if (cmd.equals("2")) {
				cmdSearch(scanner, cal);
			} else if (cmd.equals("3")) {
				cmdCalendar(scanner, cal);
			} else if (cmd.equals("h")) {
				printMenu();
			} else if (cmd.equals("q")) {
				break;
			}
		}

		System.out.println("Thank you, Bye~");
		scanner.close();
	}

	private void cmdCalendar(Scanner scanner, Calendar cal) {
		int month;
		int year;
		System.out.println("년도를 입력하세요.");
		System.out.print("YEAR ->");
		year = scanner.nextInt();

		System.out.println("월을 입력하세요");
		System.out.print("MONTH ->");
		month = scanner.nextInt();

		if (month > 12 || month < 1) {
			System.out.printf("잘못된 입력입니다.\n", month);
			return;
		}
		cal.printCalendar(year, month);

	}

	private void cmdSearch(Scanner scanner, Calendar cal) {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요(yyyy-MM-dd).");
		String date = scanner.next();
		String plan = "등록된 일정이 없습니다.";
		try {
			plan = cal.searchPlan(date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println("일정 검색 중 오류가 발생했습니다.");
		}
		System.out.println(plan);
	}

	private void cmdRegister(Scanner scanner, Calendar cal) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요(yyyy-MM-dd).");
		String date = scanner.next();
		String text = "";
		scanner.nextLine(); // ignore one newline
		System.out.println("일정을 입력해 주세요.");
		text = scanner.nextLine();

		cal.registerPlan(date, text);
	}

	public static void main(String[] args) throws ParseException {
		// 셸 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}

}
