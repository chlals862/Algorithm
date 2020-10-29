package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*
10 3
1 2 3 4 5 -1 -2 -3 -4 -5

1 5 -3

6 10 5

2 7 2
order[] = > 변화량에 대한 배열

1. -> 1 5 -3  
uphill = 0 
order[] => 0 0 0 0 0 0 0 0 0 0

uphill = -3   
order[1] = 0;
uphill -> uphill + order[1] -> -3
order[1] -> -3
-3 0 0 0 0 0 0 0 0 0
order[2] = uphill + order[2] -> -3
-3 0 0 0 0 3 0 0 0 0 0 -> order[6]부터 다시 0

2. -> 6 10 5
현재 order[] => -3 0 0 0 0 3 0 0 0 0
6 ~ 10번째 5 덮기
-3  0  0  0   0 8 0 0 0 0 0 -5
-3 -3 -3 -3 -3 5 5 5 5 5 0 

3. -> 2 7 2
현재 order[] =>
 -3 0 0 0 0 8 0 0 0 0 -5
2 ~ 7 번째 2 덮기
-3  2  0  0  0 8 0 -2 0 0 -5[11번째]
		*/
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
			if (num < 0) {
				order[startR] += num;
				order[endR] += -num;
			} else if(num > 0) {
				order[startR] += num;
				if(endR == map.length) {
					order[order.length-1] -= num;
				}else order[endR] -= num;
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
