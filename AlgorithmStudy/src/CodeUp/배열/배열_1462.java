package CodeUp.배열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 배열_1462 {
	static int N;
	static int[][] map;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		int num = 1;
		for(int col=0;col<N;col++) {
			for(int row=0;row<N;row++) {
				map[row][col] = num++;
			}
		}
		printMap();
		bw.flush();
		bw.close();
	}
	private static void printMap() throws IOException {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				bw.write(map[row][col] + " ");
			}
			bw.write("\n");
		}
	}
}
