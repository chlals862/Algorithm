package javaStudy.ch04_조건문과반복문;

public class FlowEx29_doWhile문응용 {
	/*
	 * 369게임 -> 1부터 100까지 출력
	 * */
	public static void main(String[] args) {
		
		for(int i = 1; i <= 100; i++) {
			System.out.printf("i=%d ", i);
			
			int tmp = i;
			
			do {
				// tmp%10이 3의 배수인지 확인 (0 제외)
				if(tmp%10%3 == 0 && tmp%10 != 0) //tmp를 10으로 나누고 그 값을 3으로 나눈 몫이 0일때 -> 3의 배수 , tmp를 10으로 나눴을 때 나머지가 0이 아니면 짝
					System.out.print("짝");
				// tmp /= 10은 tmp = tmp /10과 동일
			} while((tmp /= 10) != 0); //tmp를 10으로 나눳을떄 값이 0이 아닐때 까지 반복
			
				System.out.println();
		}//for end[0
	}
}
