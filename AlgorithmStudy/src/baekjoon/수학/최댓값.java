package baekjoon.수학;

import java.util.Scanner;

/*9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
예를 들어, 서로 다른 9개의 자연수
3, 29, 38, 12, 57, 74, 40, 85, 61
이 주어지면, 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.*/
//첫 째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다. 주어지는 자연수는 100 보다 작다.
//첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 몇 번째 수인지를 출력한다.
public class 최댓값 {
	static int[] arr = new int[9];
	static int max = 0;
	static int idx = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//입력 && 로직
		for(int i=0;i<9;i++) {
			int input = sc.nextInt();
			arr[i] = input; //배열에 입력한 숫자 담기
			max = Math.max(arr[i], max);
			
		}
		
		for(int i=0;i<arr.length;i++) {
			//max를 찾았으니 그 max의 인덱스값 찾기
			if(arr[i] == max) {
				idx = i;
				break;
			}
		}
		
		//출력
		//제일 큰수 
		System.out.println(max);
		//큰수의 인덱스
		System.out.println(idx+1);
	}
}
