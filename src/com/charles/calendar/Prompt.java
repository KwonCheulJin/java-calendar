package com.charles.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal-> ";

	public void runPrompt() {

		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		int month = 1;
		while (true) {
			System.out.println("월을 입력하세요");
			System.out.print(PROMPT);
			month = scanner.nextInt();
			if (month <= 0) {
				System.out.printf("%d월은 존재하지 않습니다. 프로그램을 종료합니다.\n", month);
				break;
			}
			if (month > 12) {
				System.out.printf("%d월은 존재하지 않습니다. 다시 입력해주세요\n", month);
				continue;
			}
			cal.printCalendar(2021, month);
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
