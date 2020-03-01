package javaStudy.ch5_배열;

import java.util.Arrays;

public class ArrayEx02_배열출력 {

	/*
	 * Arrays.toString(배열이름) -> 배열의 모든 요소를 '[첫번째 요소,두번째 요소 ...]'와 같은 형식으로 문자열로 만들어서 반환
	 * */
	public static void main(String[] args) {
		
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];
		int[] arr3 = new int[] {100,95,80,70,60};
		char[] chArr = {'a','b','c','d'};
		
		for(int i=0; i < arr1.length; i++) {
			arr1[i] = i+ 1; //1~10 순서대로 배열에 넣음
		}
		for(int i=0; i < arr2.length; i++) {
			arr2[i] = (int)(Math.random()*10) + 1; //1~10 랜덤 값을 배열에 저장
		}
		
		//출력
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+ ",");
		}
		
		System.out.println();
		System.out.println(Arrays.toString(arr2));//math.random
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(chArr));
		
		System.out.println(arr3);//참조변수를 그대로 출력은 할수없음 ->내부주소 출력함
		System.out.println(chArr);//char형식의 배열은 그대로 출력가능
		
		
	}
}
