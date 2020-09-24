package baekjoon.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 가장큰정사각형 {
	static int R,C,result;
	static char[][] map;
	static int[][] map2 = new int[1001][1001];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int row=0;row<R;row++) {
			String sLine = br.readLine();
			for(int col=0;col<C;col++) {
				map[row][col] = sLine.charAt(col);
				if(map[row][col] == '1') {
					map2[row][col] = 1;
					result = 1;
				}
			}
		}
		for(int row=1;row<R;row++) {
			for(int col=1;col<C;col++) {
				if(map[row-1][col] == '1' && map[row-1][col-1] == '1' && map[row][col-1] == '1') {
					map2[row][col] = Math.min(map2[row-1][col], map2[row-1][col-1]);
					map2[row][col] = Math.min(map2[row][col], map2[row][col-1]) +1;
				}
				result = Math.max(map2[row][col], result);
			}
		}
		bw.write(result * result + "\n");
		bw.flush();
		bw.close();
	}
}
