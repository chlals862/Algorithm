package baekjoon.정렬;

import java.util.Arrays;
import java.util.Scanner;

/*배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자. */
public class 소트인사이드 {
	static int[] arr;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//int input = sc.nextInt();
		String input = sc.next();
		arr = new int[input.length()];
		
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			
			arr[i] = Character.getNumericValue(ch);
		}
		
		Arrays.sort(arr);
		
		for(int i=arr.length-1;i>=0;i--) {
		System.out.print(arr[i]);
		}
		//List<Integer> list = Arrays.asList(arr);
		
		
		//arr = list.toArray(new Integer[list.size()]);
		//System.out.println("reverse() = " + list);
		
	}
}
