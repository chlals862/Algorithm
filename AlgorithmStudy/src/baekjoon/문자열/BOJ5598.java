package baekjoon.문자열;

import java.util.Scanner;

public class BOJ5598 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.nextLine().toCharArray();
		
		for(int row=0;row<ch.length;row++) {
			//A -> X
			if(ch[row] == 65) {
				ch[row] = 91;
			}
			//B -> Y
			else if(ch[row] == 66) {
				ch[row] = 92;
			}
			//C -> Z
			else if(ch[row] == 67) {
				ch[row] = 93;
			}
			System.out.print((char)(ch[row]-3));
		}
		
	}
}
