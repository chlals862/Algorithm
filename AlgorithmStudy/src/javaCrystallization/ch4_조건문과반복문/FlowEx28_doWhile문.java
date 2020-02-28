package javaCrystallization.ch4_조건문과반복문;

import java.util.Scanner;

public class FlowEx28_doWhile문 {

	public static void main(String[] args) {
		
		int input = 0, answer = 0;
		
		answer = (int)(Math.random() * 100) + 1; //1~100사이의 임의의 수 저장
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.print("1과 100사이의 정수를 입력하세요.>");
			input = scanner.nextInt();
			
			if(input > answer) {
				System.out.println("더 작은 수로 다시 시도!");
			} else if(input < answer) {
				System.out.println("더 큰 수로 다시 시도!");
			}
		} while(input != answer); //input값과 answer값이 다르면 do { } 반복 및 같을 시 빠져나옴
		
		System.out.println("정답!");
	}
}
