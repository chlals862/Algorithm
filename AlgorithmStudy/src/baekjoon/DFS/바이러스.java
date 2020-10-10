package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 바이러스 {
	static int T, network, X, Y,cnt;
	static int[][] map;
	static boolean[] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		setData();
		logic();
	}

	private static void logic() throws IOException {
		dfs(1);
		//printData();
		bw.write(cnt+"\n");
		bw.flush();
		bw.close();
	}

	private static void dfs(int i) {
		visit[i] = true;
		for(int dir=1;dir<T;dir++) {
			//System.out.println("i = " + i);
			//System.out.println("dir = " + dir);
			if(map[i][dir] == 1 && !visit[dir]) {
				//System.out.println("true i = " + i);
				//System.out.println("true dir = " + dir);
				//System.out.println("map = " + map[i][dir]); 
				//printData();
				dfs(dir);
				cnt++;
			}
		}
	}
	private static void setData() throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine())+1;
		map = new int[T][T];
		visit = new boolean[T];
		network = Integer.parseInt(br.readLine());
		for (int i = 0; i < network; i++) {
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			map[X][Y] = map[Y][X] = 1;
		}
	}
}
