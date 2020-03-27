package javaStudy.practice.배열;

import java.util.Arrays;

public class 배열_최대값_최소값_sort {

	public static void main(String[] args) {
		int array[] = {4,3,2,1,10,8,7,6,9,5};
		
		int max = array[0];
		int min = array[0];
		
		Arrays.sort(array);
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]);//1,2,3,4,5,6,7,8,9,10
		}
		System.out.println();
		System.out.println("최소값 : " + array[0]);
		System.out.println("최대값 : " + array[array.length-1]);
	}
}
