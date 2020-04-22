package baekjoon.에라토스테네스의체;

import java.util.Scanner;

//주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
public class 소수찾기 {
	static int num;
	static int count;
	public static void main(String[] args) {
		//에리스토테네스의 체 구현해보기 -> 소수가 뭔지 미리 정함
		//->boolean은 default값 false
		boolean[] prime = new boolean[1001]; 
		prime[0] = true; //boolean은 기본값이 false이므로
		prime[1] = true; // 0,1,2 인덱스 또한 false이다, 0,1은 소수가 아니므로 따로 true로 지정
		//true -> 소수X , false -> 소수O 
		for(int i=2;i<=1000;i++) {
			//2의 배수 , 2보다 클때 
			if(i > 2 && i % 2 == 0) 
				continue; //아래 반복문으로
			
			for(int j=2;(i*j)<=1000;j++) {
				prime[i*j] = true;
				
			}
		}
//		for(int i=2;i<1000;i++) {
//			if(prime[i] == false) 
//				System.out.println("i= " +i);
//		}
		//입력
		Scanner sc = new Scanner(System.in);
		
		int inputNum = sc.nextInt();
		
		for(int i=0;i<inputNum;i++) {
			num = sc.nextInt();
		
			if (prime[num] == false) {
				count++;		
			}
		}
		System.out.println(count);

	}
}
