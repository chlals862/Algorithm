package baekjoon.시뮬레이션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 평균 {
	static double avg;
	static double[] num;
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int inputNum = sc.nextInt();
		double num[] = new double[inputNum];
		
		for(int i=0;i<inputNum;i++) {
			num[i] = sc.nextDouble();
		
		}
		Arrays.sort(num);
		
		double M = num[inputNum-1];

		  for(int i=0;i<inputNum;i++) {
		  
		  avg += num[i]/M*100; 
		  }
		  System.out.println(avg/inputNum);
		 
	}
}
