package baekjoon.시뮬레이션;

import java.util.Scanner;

public class 숫자의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int Z = sc.nextInt();
		
		int[] output = new int[10]; //0123456789 배열
		
		int result = 0;
		if(X >= 100 && X < 1000 && Y >= 100 && Y < 1000 && Z >= 100 && Z <1000) {
			result = X*Y*Z;
	}
		
		/*
		      result값을 문자열로 치환해서 그 문자 길이만큼 반복문에서
		 * String stringNumber = Integer.toString(result); 
		 * for(inti=0;i<stringNumber.length();i++) {
		 * 
		 * 하나씩 하나씩 조사를 하여 
		 * char chracterNumber = stringNumber.charAt(i);
		 * 
		 * 조사한 캐릭터 배열을 int로 다시 치환하여 
		 * int num = Character.getNumericValue(chracterNumber);
		 * 
		 	output배열의 num에다가 각각 +1를 해줌
		 * output[num]++; 
		 * }
		 * */
		if(result > 0) {
			while(result!=0) {
				output[result%10]++;
				result/=10;
			}
		}
		
		for(int i=0;i<output.length;i++) {
			System.out.println(output[i]);
		}
		
	}
}
