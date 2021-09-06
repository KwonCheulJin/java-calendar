package com.charles.calendar;

import java.util.Scanner;

public class Prompt {

	/**
	 * @param week 요일명
	 * @return 0 ~ 6 (0 = 일요일(default))
	 */
	public int getParseDay(String week) {

		switch (week) {
		case "일":
			return 0;
		case "월":
			return 1;
		case "화":
			return 2;
		case "수":
			return 3;
		case "목":
			return 4;
		case "금":
			return 5;
		case "토":
			return 6;
		default:
			return 0;

		}
	}

	public void runPrompt() {

		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		int month = 1;
		int year = 2021;

		while (true) {
			System.out.println("년도를 입력하세요.(exit: -1)");
			System.out.print("YEAR ->");
			year = scanner.nextInt();
			if (year == -1) {
				break;
			}

			System.out.println("월을 입력하세요");
			System.out.print("MONTH ->");
			month = scanner.nextInt();


			if (month > 12 || month < 1) {
				System.out.printf("%d월은 존재하지 않습니다. 다시 입력해주세요\n", month);
				continue;
			}
			cal.printCalendar(year, month);
		}
		System.out.println("Bye~");
		scanner.close();

	}

	public static void main(String[] args) {
		// 셸 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}

}
