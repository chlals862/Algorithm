package baekjoon.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 분해합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	//static int output;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int output = 0;
		for(int i=0;i<N;i++) {
			int num = i;
			int sum = 0;
			//각 자리수를 더하기
			while(num != 0) {
				sum += num %10; 
				num /= 10;
			}
			//생성자 찾기 i값과 각 자리수 누적합이 같을때
			if(sum + i == N) {
				output = i;
			break;
			}
		}
		bw.write(output+"\n");
		bw.flush();
		bw.close();
	}

}
