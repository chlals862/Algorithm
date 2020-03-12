package javaStudy.ch04_조건문과반복문;

import java.util.Scanner;

public class FlowEx34_이름붙은반복문 {
	
	public static void main(String[] args) {
		int menu = 0; 
		int num = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		outer : while(true) {
			System.out.println("(1) square");
			System.out.println("(2) square root");
			System.out.println("(3) log");
			System.out.println("원하는 메뉴(1~3)를 선택하세요. (종료는 0)");
			
			String tmp = scanner.nextLine();//화면에서 입력받은 내용을 tmp에 저장
			menu = Integer.parseInt(tmp); //문자열인 tmp를 숫자로 변환
			
			if(menu==0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if(!(1<= menu && menu <= 3)) {
				System.out.println("메뉴를 잘못 선택하셨습니다. 종료는(0)");
				continue; //->반복문을 벗어 나지 않음
			}
			
			for(;;) {
				System.out.println("계산할 값을 입력하세요. (계산 종료:0, 전체종료:99)>");
				tmp = scanner.nextLine();
				num = Integer.parseInt(tmp);
				
				if(num==0) //계산종료
					break; //제일 가까운 반복문 종료 -> for문을 벗어남
				if(num==99)
					break outer;//반복문 제일 바깥인 outer종료 ->for문 while문 전부 벗어나므로 전체 종료
				
				switch(menu) {
					
				  case 1:
					System.out.println("result="+num*num);//메뉴 1번일떄 계산값
				  break;
				  
				  case 2:
					  System.out.println("result="+Math.sqrt(num));//메뉴 2번일때 계산값 주어진 숫자에 루트를 씌우며 , 음수일떄는 nan반환
				  break;
				  
				  case 3:
					  System.out.println("result="+Math.log(num));//메뉴 3번일때 계산값
				  break;
				}//switch of end
			}//for of end
		}//while of end
	}//main of end
}
