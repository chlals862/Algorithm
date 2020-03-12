package javaStudy.ch05_배열;

public class ArrayEx07_배열복사3 {
	/*
	 * 길이가 10인 배열 numArr을 생성하고 0~9의 숫자로 차례대로 초기화하여 출력
	 * random()을 이용하여 배열의 임의의 위치에 있는 값과 배열의 첫 번째 요소인 numArr[0]의 값을 교환하는 일을 100번 반복
	 * 두 변수에 저장된 값을 서로 바꾸려면 별도의 변수 tmp를 사용
	 * */
	public static void main(String[] args) {
		int[] numArr = new int[10];
		
		for(int i=0; i<numArr.length;i++) {
			numArr[i] = i; //배열을 0~9의 숫자로 초기화
			System.out.print(numArr[i]); //0123456789
		}//for of end
		System.out.println();
		
		for(int i=0; i<100;i++) {
			int n = (int)(Math.random()*10);
			// numArr[0]과 numArr[n]의 값을 서로 바꿈
			int tmp = numArr[0]; //numArr[0]의 값을 tmp에 저장
			numArr[0] = numArr[n];
			numArr[n] = tmp;
		}
		
		for(int i=0; i<numArr.length;i++) {
			System.out.print(numArr[i]);
		}
	}//main of end
}
