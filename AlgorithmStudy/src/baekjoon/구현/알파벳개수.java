package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 알파벳개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		// st = new StringTokenizer(br.readLine());
		 char[] word = br.readLine().toCharArray();
		 int[] alpha = new int[26];
		 for(int i=0;i<word.length;i++) alpha[(int)word[i]-97] += 1;
		 
		 for(int i=0;i<alpha.length;i++) bw.write(alpha[i]+" ");
		 bw.flush();
		 bw.close();
	}

}
