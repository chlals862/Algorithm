package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 바닥장식 {
	static int R, C;
	static char[][] map;
	static int[] dr = { 0, 1 }; // 우 하
	static int[] dc = { 1, 0 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		int num = 0;
		for (int row = 0; row < R; row++) map[row] = br.readLine().toCharArray();
		
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == '-') {
					num++;
					while(col < C && map[row][col] == '-') {
						col++;
					}
				}
			}
		}
		for(int col=0;col<C;col++) {
			for(int row=0;row<R;row++) {
				if(map[row][col] == '|') {
					num++;
					while(row < R && map[row][col] == '|') {
						row++;
					}
				}
			}
		}
		bw.write(num+"");
		bw.flush();
		bw.close();
	}

}
