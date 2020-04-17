package baekjoon.그리디알고리즘;
//타로는 자주 JOI잡화점에서 물건을 산다.
//JOI잡화점에는 잔돈으로 500엔, 100엔, 50엔, 10엔, 5엔, 1엔이 충분히 있고, 
//언제나 거스름돈 개수가 가장 적게 잔돈을 준다.
//타로가 JOI잡화점에서 물건을 사고 카운터에서 1000엔 지폐를 한장 냈을 때, 
//받을 잔돈에 포함된 잔돈의 개수를 구하는 프로그램을 작성하시오.
//예를 들어 입력된 예1의 경우에는 아래 그림에서 처럼 4개를 출력해야 한다.
import java.util.Scanner;

public class 거스름돈 {
	static int money = 1000;
	static int[] coin = {500,100,50,10,5,1};
	static int price;//가격
	static int mok; //몫
	static int na;//나머지
	static int resultMoney; //거스름돈
	static int num; //동전수
	public static void main(String[] args) {
		
		inputData();
		logic();
		outputData();
	}

	private static void outputData() {
		System.out.println(num);
		
	}

	private static void logic() {
		 //거스름돈 = 1000 - 380 -> 620
		resultMoney = money - price;
		
		for(int i=0;i<coin.length;i++) {
			//만약에 거스름돈이 코인값 보다 작으면 다음꺼 -> 계속
			//coin[i] -> 500 100 50 10 5 1
			//620 < coin[i] 
			if(resultMoney < coin[i]) {
				continue;
			}
		//몫 -> 거스름돈 나누기 Coin[i]번째
		mok = resultMoney / coin[i];
		//나머지 -> 거스름돈 % Coin[i]번째
		na = resultMoney % coin[i];
		//줄 돈은 거스름돈에
		resultMoney = na; 
		//동전수 += 몫
		num += mok;
		
		//System.out.println("몫 = " +mok);
		//System.out.println("나머지 = " + na);
		//System.out.println("동전수 = " + num);
		//System.out.println("거스름돈 = " + resultMoney);
		//System.out.println();
		}
		
		
	}
	private static void inputData() {
		Scanner sc = new Scanner(System.in);
		//가격입력
		price = sc.nextInt();
	}
}
