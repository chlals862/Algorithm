package baekjoon.시뮬레이션;

import java.io.IOException;
import java.util.Scanner;

/*
 *  입력한 수 5개를 1,2,3,4,5순으로 만들기
 *  첫 번째 조각의 수가 두 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.
	두 번째 조각의 수가 세 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.
	세 번째 조각의 수가 네 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.
	네 번째 조각의 수가 다섯 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.
	만약 순서가 1, 2, 3, 4, 5 순서가 아니라면 1 단계로 다시 간다.
 *  -> 버블정렬을 하면 될 것 같다.
 *  [input]
 *  2 1 5 3 4
 *  [output]
 *  1 2 5 3 4
 *  1 2 3 5 4
 *  1 2 3 4 5
 *  
 *  [input]
 *  2 3 4 5 1
 *  [output]
 *  2 3 4 1 5
 *  2 3 1 4 5
 *  2 1 3 4 5
 *  1 2 3 4 5
 * */
public class 나무조각 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for(int row=0;row<arr.length;row++) {
			arr[row] = sc.nextInt();
		}
		//show(arr);
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					show(arr);
				}
			}
			
		}
	}

	private static void show(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
