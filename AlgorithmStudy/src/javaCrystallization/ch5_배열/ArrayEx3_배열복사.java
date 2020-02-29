package javaCrystallization.ch5_배열;

public class ArrayEx3_배열복사 {

	public static void main(String[] args) {
		
		int[] arr = new int[5];
		
		for(int i=0; i<arr.length;i++) {//배열 arr 1~5를 저장
			arr[i] = i+1;
		}
			System.out.println("[변경전]");
			System.out.println("arr.length:"+arr.length);
			
			for(int i=0; i<arr.length;i++) 
				System.out.println("arr["+i+"]:"+arr[i]);
				
			int[] tmp = new int[arr.length*2];
			
			//배열복사
			for(int i=0; i< arr.length; i++) 
				tmp[i] = arr[i];
				arr = tmp; //tmp에 저장된 값을 arr에 저장
				System.out.println("[변경후]");
				System.out.println("arr.length:"+arr.length);
				
				for(int i=0; i<arr.length;i++)
					System.out.println("arr["+i+"]:"+arr[i]);
	}
}