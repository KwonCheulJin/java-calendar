package com.charles.calendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Calendar {

	private static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final String SAVE_FILE = "calendar.dat";
	private HashMap<Date, PlanItem> planMap;
	
	
	public Calendar() {
		planMap = new HashMap<Date, PlanItem>();
		File f = new File(SAVE_FILE);
		if(!f.exists()) {
			return;
		}
		try (Scanner scanner = new Scanner(f)){
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] words = line.split(",");
				String date = words[0];
				String detail = words[1];
				PlanItem p = new PlanItem(date, detail);
				planMap.put(p.getDate(), p);
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * @param date ex: "2021-09-06"
	 * @param plan
	 * @throws ParseException 
	 */
	public void registerPlan(String inputDate, String plan) {
		PlanItem p = new PlanItem(inputDate, plan);
		planMap.put(p.getDate(), p);
		
		File f = new File(SAVE_FILE);
		String item = p.saveString();
		try (FileWriter fw = new FileWriter(f, true)){
			fw.write(item);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public PlanItem searchPlan(String inputDate){
		Date date = PlanItem.getDateFromString(inputDate);
		return planMap.get(date);
	}
	
	public boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		} else {
			return MAX_DAYS[month];
		}
	}

	public void printCalendar(int year, int month) {
		System.out.printf("  <<%4d???%3d???>> \n", year, month);
		System.out.println(" ??? ??? ??? ??? ??? ??? ???");
		System.out.println("---------------------");

		int maxDay = getMaxDaysOfMonth(year, month);

		// get weekday automatically
		int weekday = getWeekDay(year, month, 1);
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

	public int getWeekDay(int year, int month, int day) {
		int standardYear = 1970;
		final int STANDARD_WEEKDAY = 4; //1970/Jan/1st = Thursday
		
		int count = 0;
		
		for(int i = standardYear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}

		for(int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}
		
		count += day - 1;
		
		int weekday = (count + STANDARD_WEEKDAY) % 7;
		
		return weekday;
	}
	
	public static void main(String[] args) throws ParseException {
		Calendar cal = new Calendar();
		cal.registerPlan("2021-09-06", "Let's eat beef");
		System.out.println(cal.searchPlan("2021-09-06").equals("Let's eat beef"));
	}

}
