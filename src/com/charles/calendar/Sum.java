package com.charles.calendar;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		System.out.println("두 수를 입력해주세요 > ");
		Scanner scanner = new Scanner(System.in);
		String inputValues = scanner.nextLine();
		String[] resultValues = inputValues.split(" ");
		
		int one = Integer.parseInt(resultValues[0]);
		int two = Integer.parseInt(resultValues[1]);
		
//		System.out.println("두 수의 합은 ? " + (one + two));
		System.out.printf("%d와 %d의 합은 ? %d입니다", one, two, one+two);
		scanner.close();
	}

}
