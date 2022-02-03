package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 결혼식 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int a,b,result;
	static int[][] map;
	static boolean[] flag;
	public static void main(String[] args) throws IOException {
		//st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		flag = new boolean[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			map[a][b] = 1; map[b][a] = 1;
		}
		for(int i=2;i<N + 1;i++) {
			if(map[1][i] == 1) {
				if(!flag[i]) {
				result++;
				flag[i] = true;
			}
			for(int j=2;j<N+1;j++) {
				if(map[i][j] == 1 && !flag[j]) {
					result++;
					flag[j] = true;
				}
			}
		}
	}
		bw.write(result+"");
		bw.flush();
		bw.close();
	}

}
