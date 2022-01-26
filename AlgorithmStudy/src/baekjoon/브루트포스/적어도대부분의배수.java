package baekjoon.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 적어도대부분의배수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int[] num = new int[5];
		int cnt = 0;
		int max = 1; //완전탐색 -> 1부터 while문 종료까지 계속 증가시키면서 배수를 찾는다.
 		for(int i=0;i<5;i++) num[i] = Integer.parseInt(st.nextToken());
		
		while(true) {
			for(int i=0;i<5;i++) {
				if(max % num[i] == 0) cnt++;
			}
			if(cnt >= 3) {
				bw.write(max+"");
				break;
			}
			cnt = 0;
			
			max++;
		}
		bw.flush();
		bw.close();
	}

}
