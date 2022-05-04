package baekjoon.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 수들의합5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int count = 1;
		int start = 1;
		int end = 1;
		int sum = 1;

		while(end != N) {
			if(sum == N) {
				count++;
				end++;
				sum += end;
			} else if(sum > N) {
				sum -= start;
				start++;
			} else {
				end++;
				sum += end;
			}
		}
		bw.write(count+"");
		bw.flush();
		bw.close();
	}

}
