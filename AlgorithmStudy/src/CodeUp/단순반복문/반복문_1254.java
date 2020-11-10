package CodeUp.단순반복문;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 반복문_1254 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		char a = str1.charAt(0);
		String str2 = sc.next();
		char b = str2.charAt(0);
		for(char row=a;row<=b;row++) {
			bw.write(row + " ");
		}
		bw.flush();
		bw.close();
	}
}
