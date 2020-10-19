package 정올;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 바이러스 {
	static int total,T,X,Y,result;
	static int[][] network;
	static boolean[] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		total = Integer.parseInt(st.nextToken())+1;
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		network = new int[total][total];
		visit = new boolean[total];
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			network[X][Y] = network[Y][X] = 1;
		}
		dfs(1);
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
	private static void dfs(int cr) {
		visit[cr] = true;
		for(int dir=0;dir<total;dir++) {
			if(network[cr][dir] == 1 && !visit[dir]) {
				visit[dir] = true;
				dfs(dir);
				result++;
			}
		}
	}
}