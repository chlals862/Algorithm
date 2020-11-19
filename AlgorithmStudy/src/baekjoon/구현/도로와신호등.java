package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 도로와신호등 {
	static int K,C,D,R,G;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int time = 0;
		int nr = 0;
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			time += D-nr;
			nr = D;
			int red = time%(R+G);
			if(red <=R) time+=(R-red);
		}
		time += C-nr;
		bw.write(time+"");
		bw.flush();
		bw.close();
	}
}
