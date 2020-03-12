package javaStudy.ch04_조건문과반복문;

import java.util.Scanner;

public class FlowEx27_While문2 {
 
	/*
	 * 사용자로부터 반복해서 숫자를 입력받다가 0을 입력시 입력을 마치고 총 합을 출력
	 * 
	 * */
	public static void main(String[] args) {
		int num;
		int sum = 0;
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("합계를 구할 숫자를 입력하세요. (끝내려면 0을 입력)");
		
		while(flag) {
			System.out.print(">>");
			
			String tmp = scanner.nextLine();
			num = Integer.parseInt(tmp);
			
			if(num != 0) {
				sum += num; //num이 0이 아니면 sum에 더함
			} else {
				flag = false;
			}
		}
		System.out.println("합계 :" + sum);
	}
}
