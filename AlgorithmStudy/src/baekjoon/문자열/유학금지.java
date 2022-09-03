package baekjoon.문자열;

import java.util.Scanner;

public class 유학금지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		char[] ch = str.toCharArray();
		for(int row=0;row<ch.length;row++) {
			if(ch[row] == 'C' || ch[row] == 'A' || ch[row] == 'M' || ch[row] == 'B' ||
					ch[row] == 'R' || ch[row] == 'R' || ch[row] == 'I' || ch[row] == 'D' ||
					ch[row] == 'G' || ch[row] == 'E') {
					ch[row] = ' ';
					str = String.valueOf(ch).replaceAll(" ", "");
			}
		}
		System.out.println(str);
	}
}
