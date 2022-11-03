package baekjoon.시뮬레이션;

import java.util.Scanner;

public class BOJ3028 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] cup = {true,false,false};
		String str = sc.next();
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == 'A') {
				if(cup[0]) {
					cup[0] = false;
					cup[1] = true;
				} 
				else if(cup[1]) {
					cup[0] = true;
					cup[1] = false;
				}
				else if(!cup[0] && !cup[1]) {
					cup[0] = false;
					cup[1] = false;
				}
			}else if(str.charAt(i) == 'B') {
				if(cup[1]) {
					cup[1] = false;
					cup[2] = true;
				}
				else if(cup[2]) {
					cup[1] = true;
					cup[2] = false;
				}
				else if(!cup[1] && !cup[2]) {
					cup[1] = false;
					cup[2] = false;
				}
			}else {
				if(cup[0]) {
					cup[0] = false;
					cup[2] = true;
				}
				else if(cup[2]) {
					cup[2] = false;
					cup[0] = true;
				}
			}
		}
		for(int i=0;i<cup.length;i++) {
			if(cup[i]) {
				System.out.println(i+1);
			}
		}
		
	}
}
