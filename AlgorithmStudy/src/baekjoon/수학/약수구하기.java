package baekjoon.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 약수구하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		ArrayList<Integer> num = new ArrayList<Integer>();
		for(int i=1;i<=N;i++) {
			if(N%i == 0) {
				num.add(i);
				cnt++;
			}
		}
		if(cnt < K) {
			bw.write(0+"\n");
		}else bw.write(num.get(K-1)+"");
		
		bw.flush();
		bw.close();
	}

}
