package baekjoon.에라토스테네스의체;

import java.util.Scanner;

public class 소수구하기 {

	public static void main(String[] args) {
		
		//에리스토테네스의체를 미리 구현하자 - 소수가 뭔지 미리 정함
		boolean[] prime = new boolean[1000001];
		prime[0] = true; //boolean은 기본값이 false이므로
		prime[1] = true; // 0,1,2 인덱스 또한 false이다, 0,1은 소수가 아니므로 따로 true로 지정
		//내꺼로 만들자
		//★true -> 소수X
		//★false-> 소수O
		
		for(int i=2;i<=prime.length-1;i++) {
			
			if(i>2 && i%2 ==0) 
				continue;
			
			for(int j=2;(i*j)<=prime.length-1;j++) {
				prime[i*j] = true;
			}
		}
		//---------------------------------------------
		Scanner sc = new Scanner(System.in);
		
		int min = sc.nextInt();
		int max = sc.nextInt();
		
		for(int i=min;i<=max;i++) {
			
			if(prime[i] == false) {
				System.out.println(i);
			}
		}
	}
}
