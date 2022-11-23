package baekjoon.문자열;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ10820 {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);

		while(sc.hasNextLine()) {
			String str = sc.nextLine();
			int[] result = new int[4];
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
					result[0]++;
				}else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
					result[1]++;
				}else if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
					result[2]++;
				}else result[3]++;
			}
			System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
		}
		sc.close();
	}
}
