package CodeUp.조건문;

import java.util.Scanner;

public class _1214 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		int month = sc.nextInt();

		int result = 0;

		// 윤년 판별
		if (month == 2) { // 2월달일때는 윤년판별
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
				result = 29;
			} else
				result = 28;
		}else if(month != 2) { //2월달이 아닐 떄는 윤년판별 X,월별 일만.
			if(month == 1 || month == 3 || month == 5 || month == 7 
					|| month == 8 || month == 10 || month == 12) {
				result = 31;
			}else result = 30;
		}

		System.out.println(result);
	}
}
