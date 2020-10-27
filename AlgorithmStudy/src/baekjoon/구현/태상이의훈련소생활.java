package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 태상이의훈련소생활 {
	static int N, K, uphill;
	static int[] map;
	static int[] order;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1];
		order = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int row = 0; row < N; row++) {
			map[row] = Integer.parseInt(st.nextToken());
		}
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(st.nextToken()) - 1;
			int endR = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			uphill = num;
			if (num < 0) {
				order[startR] += uphill;
				order[endR] += -uphill;
			} else if(num > 0) {
				order[startR] += uphill;
				if(endR == map.length) {
					order[order.length-1] -= uphill;
				}else order[endR] -= uphill;
			}
		}
		int num = order[0];
		map[0] += num;
		for(int row=1;row<order.length;row++) {
			num = num + order[row];
			map[row] += num;
		}
		printMap();
		bw.flush();
		bw.close();
	}
	private static void printMap() throws IOException {
		for (int row = 0; row < N; row++) {
			bw.write(map[row]+" ");
		}
	}
}
