package baekjoon.문자열;

import java.util.Scanner;

public class 문자열분석 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			String str = sc.nextLine();
			
			int lower = 0;
			int upper = 0;
			int number = 0;
			int blank = 0;
			
			for(int row=0;row<str.length();row++) {
				if(str.charAt(row) >= 97 && str.charAt(row) <= 122) lower++;
				else if(str.charAt(row) >= 65 && str.charAt(row) <= 90) upper++;
				else if(str.charAt(row) >= 48 && str.charAt(row) <= 57) number++;
				else if(str.charAt(row) == 32) blank++;
			}//for
			System.out.println(lower + " " + upper + " " + number + " " + blank);
		}//while
		sc.close();
	}
}
