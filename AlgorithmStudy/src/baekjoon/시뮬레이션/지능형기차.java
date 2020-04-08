package baekjoon.시뮬레이션;

import java.util.Scanner;

public class 지능형기차 {
	static int totalP = 0;
	static int[] upPeople= new int[5];
	static int[] downPeople = new int[5];
	static int maxPeople;
	public static void main(String[] args) {
		set();
		trainMove();
		System.out.println(maxPeople);
	}
//	기차는 역 번호 순서대로 운행한다.
//	출발역에서 내린 사람 수와 종착역에서 탄 사람 수는 0이다.
//	각 역에서 현재 기차에 있는 사람보다 더 많은 사람이 내리는 경우는 없다.
//	기차의 정원은 최대 10,000명이고, 정원을 초과하여 타는 경우는 없다.

	private static void trainMove() {
		for(int station = 1; station <= 4; station++) {
			totalP = totalP - downPeople[station];
			totalP = totalP + upPeople[station];
			maxPeople = Math.max(maxPeople,totalP);
		}
	}
	
	//입력
	private static void set() {
		Scanner sc = new Scanner(System.in);
		for(int station = 1; station <= 4; station++) {
			downPeople[station] = sc.nextInt();
			upPeople[station] = sc.nextInt();
			
		}
		
	}
}
