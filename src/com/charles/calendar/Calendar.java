package com.charles.calendar;

public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		} else {
			return MAX_DAYS[month - 1];
		}
	}

	public void printCalendar(int year, int month, int weekday) {
		System.out.printf("  <<%4d년%3d월>> \n", year, month);
		System.out.println(" 일 월 화 수 목 금 토");
		System.out.println("---------------------");

		int maxDay = getMaxDaysOfMonth(year, month);

		// print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}
		// print first line
		int count = 7 - weekday;
		int delimeter = (count >= 7) ? 0 : count;
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		// print from second line to last
		for (int i = count + 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == delimeter) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}

}
