package CodeUp.배열;

import java.util.Scanner;

public class _1440 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		StringBuilder sb = new StringBuilder();
		for(int row=0;row<arr.length;row++) {
			arr[row] = sc.nextInt();
		}
		
		for(int row = 0; row < arr.length; row++){
		      sb.append(row+1 + ": ");
		      for(int col = 0; col < arr.length; col++){
		        if(arr[row] < arr[col] && row != col ){
		        	 sb.append("< ");
		        } else if(arr[row] == arr[col] && row != col){
		        	 sb.append("= ");
		        } else if(arr[row] > arr[col] && row != col){
		        	 sb.append("> ");
		        }
		      }
		      sb.append("\n");
		    }
		
		System.out.println(sb);
	}
}
