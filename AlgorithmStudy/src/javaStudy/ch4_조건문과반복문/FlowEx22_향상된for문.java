package javaStudy.ch4_조건문과반복문;

public class FlowEx22_향상된for문 {

	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) 
			System.out.printf("%d ", arr[i]);
			System.out.println();
		
		for(int tmp : arr) { //i가 0부터 arr.length보다 작을떄 까지 반복되는 반복문과 같음 
							 //배열이나 컬렉션에 저장된 요소들을 읽어오는 용도로만 사용할 수 있다는 제약이 있음
			System.out.printf("%d ", tmp);
			sum += tmp;
		}
		
		System.out.println();
		System.out.println("sum = "+sum);
		
	}
}
