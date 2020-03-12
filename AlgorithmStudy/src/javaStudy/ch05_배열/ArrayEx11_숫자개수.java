package javaStudy.ch05_배열;

public class ArrayEx11_숫자개수 {

	/*
	 * 랜덤한 각 0~9의 사이의 임의의 값을 뽑고 각 숫자가 몇 번 반복해서 나타나는지
	 * 바탕화면의 Flash 폴더의 array참고
	 * */
	public static void main(String[] args) {
		
		int[] numArr = new int[10];
		int[] counter = new int[10];
		
		for(int i=0; i<numArr.length;i++) {
			numArr[i] = (int)(Math.random() * 10);
			System.out.print(numArr[i]);
		}//for of end i
		System.out.println();
		
		for(int i=0; i<numArr.length;i++) {
			counter[numArr[i]]++;
		}//for of end i
		
		for(int i=0; i<numArr.length;i++) {
			System.out.println(i + "의 개수 :"+ counter[i]);
		}//for of end i
	}
}
