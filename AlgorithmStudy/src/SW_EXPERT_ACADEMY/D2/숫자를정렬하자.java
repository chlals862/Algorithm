package SW_EXPERT_ACADEMY.D2;

import java.util.Scanner;

public class 숫자를정렬하자 {
	static int T,size;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			size = sc.nextInt();
			arr = new int[size];
			
			for(int row=0;row<arr.length;row++) {
				arr[row] = sc.nextInt();
			}
			for(int row=0;row<arr.length-1;row++) {
				for(int col=row;col<arr.length;col++) {
					if(arr[row] > arr[col]) {
						int tmp = arr[col];
						arr[col] = arr[row];
						arr[row] = tmp;
					}
				}
			}
			System.out.print("#"+t +" ");
			for(int row=0;row<arr.length;row++) {
				System.out.print(arr[row]+" ");
			}
			System.out.println();
		}
	}
}
	
