package javaStudy.ch4_조건문과반복문;

import java.util.Scanner;

public class FlowEx32_Continue문 {

	/*
	 * 메뉴르 보여주고 선택하는 예쩨
	 * 잘못 선택시 continue문으로 다시 메뉴를 보여줌
	 * 0번 선택시 break문으로 반복문을 벗어나 프로그램이 종료
	 * 
	 * */
	public static void main(String[] args) {
		int menu = 0;
		int num = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("(1) square");
			System.out.println("(2) square root");
			System.out.println("(3) log");
			System.out.println("원하는 메뉴(1~3)번을 선택하세요.(종료는 0)");
			String tmp = scanner.nextLine();
			menu = Integer.parseInt(tmp);
			
			if(menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if(!(1 <= menu && menu <= 3)) {
				System.out.println("메뉴를 잘못 선택하셨습니다. (종료는 0)");
				continue;
			}
			
			System.out.println("선택하신 메뉴는 " + menu + "번입니다.");
			
		}//while of end
		
	}
}
