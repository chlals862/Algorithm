package baekjoon.시뮬레이션;

import java.util.Scanner;

public class 블랙잭 {
	static int num = 0;
	static int max;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cardCnt = sc.nextInt();  //카드 갯수
		int limitNum = sc.nextInt(); //딜러가 제시하는 숫자

		int[] card = new int[cardCnt]; //카드 갯수만큼의 배열

		//입력
		for(int i=0;i<cardCnt;i++) {
			int input = sc.nextInt(); //카드 배열에 입력한 숫자 넣기
			card[i] = input;
		}

		for(int i=0;i<cardCnt;i++) {			
			for(int j=i+1;j<cardCnt;j++) {
				for(int k=j+1;k<cardCnt;k++) {
					int sum = card[i]+card[j]+card[k];
					if(limitNum>=sum) {
						max = Math.max(max,sum);
					}
				}
			}

		}

		System.out.println(max);

	}
}
