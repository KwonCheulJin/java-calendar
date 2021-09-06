package com.charles.calendar;

import java.util.Scanner;

public class Prompt {


	public void runPrompt() {

		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		int month = 1;
		int year = 1;
		while (true) {
			System.out.println("년도를 입력하세요");
			System.out.print("YEAR ->");			
			year = scanner.nextInt();
			
			System.out.println("월을 입력하세요");
			System.out.print("MONTH ->");
			month = scanner.nextInt();
			if (month <= 0) {
				System.out.printf("%d월은 존재하지 않습니다. 프로그램을 종료합니다.\n", month);
				break;
			}
			if (month > 12) {
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
