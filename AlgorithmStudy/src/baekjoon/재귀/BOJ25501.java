package baekjoon.재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ25501 {
	static int cnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			String str = br.readLine();
			bw.write(isPalindrome(str)+ " "+ cnt +  "\n" );
		}
		bw.flush();
		bw.close();
	}

	private static int isPalindrome(String str) {
		cnt = 0;
		return recursion(str, 0 , str.length()-1);
	}

	private static int recursion(String str, int i, int j) {
		cnt++;
		if(i >= j ) return 1;
		else if(str.charAt(i) != str.charAt(j)) return 0;
		else return recursion(str, i+1, j-1);
	}
}
