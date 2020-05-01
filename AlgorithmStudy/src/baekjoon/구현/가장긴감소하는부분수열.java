package baekjoon.구현;

import java.util.Scanner;

public class 가장긴감소하는부분수열 {
	//static int[] arr;
	//static int[] temp;
	static int inputNum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		inputNum = sc.nextInt();
		int[] arr = new int[inputNum+1];
		int[] temp = new int[inputNum+1];
		
		for(int i=1;i<=inputNum;i++) {
			arr[i] = sc.nextInt();
		}
		temp[1] = 1;
		
		for(int i=2;i<=inputNum; i++) {
			temp[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[i] < arr[j] && temp[i] <= temp[j]) {
					temp[i] = temp[j]+1;
				}else if(arr[i] == arr[j]) {
					temp[i] = temp[j];
				}
			}
		}
		
		int result = 0;
		for(int i=1;i<=inputNum;i++) {
			result = Math.max(temp[i], result);
		}
		System.out.println(result);
		
	}
}
