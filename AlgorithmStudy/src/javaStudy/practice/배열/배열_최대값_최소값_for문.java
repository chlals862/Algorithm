package javaStudy.practice.배열;

public class 배열_최대값_최소값_for문 {

	public static void main(String[] args) {
		//최대값 최소값을 구할 int배열
		int array[] = {4,3,2,1,10,8,7,6,9,5};

		int max = array[0]; //최대값
		int min = array[0]; //최소값

		for(int i=0;i<array.length;i++) {
			if(max<array[i]) {
				max = array[i];
			}
			
			if(min>array[i]) {
				min = array[i];
			}
			
		}//for
		
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}

}
