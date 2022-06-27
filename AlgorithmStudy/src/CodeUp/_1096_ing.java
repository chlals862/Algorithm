package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1096_ing {
	static int K,R,C;
	static int[][] map;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int[][] map = new int[20][20];
		for(int row=0;row<K;row++) {
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			map[R-1][C-1] = 1;
		}
		
		
		for(int row=0;row<map.length;row++) {
			for(int col=0;col<map.length;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
	}
}
