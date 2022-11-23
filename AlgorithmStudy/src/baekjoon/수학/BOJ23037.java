package baekjoon.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ23037 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String num = br.readLine();
		
		double sum = 0;
		for(int i=0;i<num.length();i++) {
			char[] a = num.toCharArray();
			double subNum = 0;
			subNum = Character.getNumericValue(a[i]);
			sum += Math.pow(subNum, 5);
		}
		bw.write((int)sum+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
