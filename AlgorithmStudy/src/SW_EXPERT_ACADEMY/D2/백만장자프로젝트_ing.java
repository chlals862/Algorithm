package SW_EXPERT_ACADEMY.D2;

import java.util.Scanner;

public class 백만장자프로젝트_ing {
	/*
	 * 1. 원재는 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다. 
	 * 2. 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입할 수 있다. 
	 * 3. 판매는 얼마든지 할 수 있다.
	 * 
	 * 예를 들어 3일 동안의 매매가가 1, 2, 3 이라면 처음 두 날에 원료를 구매하여 마지막 날에 팔면 3의 이익을 얻을 수 있다.
	 * 
	 * [입력] 첫 번째 줄에 테스트 케이스의 수 T가 주어진다. 각 테스트 케이스 별로 첫 줄에는 자연수 N(2 ≤ N ≤ 1,000,000)이
	 * 주어지고, 둘째 줄에는 각 날의 매매가를 나타내는 N개의 자연수들이 공백으로 구분되어 순서대로 주어진다. 각 날의 매매가는 10,000이하이다. 
	 * [출력] 각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 최대 이익을 출력한다.
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long input = sc.nextInt();
		long sum = 0; //합
		int max = 0;//최대값 
		
		for(int i=1; i<=input; i++) {
			int tc = sc.nextInt();
			int[] tcList = new int[tc];//입력한 값 배열로 저장
			
			for(int j=0;j<tc;j++) {
				tcList[j] = sc.nextInt();
			}//for j of end
			
			//System.out.printf("#%d"+ );
		}//for i of end
		
		
	}
}
