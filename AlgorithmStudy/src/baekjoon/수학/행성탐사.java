package baekjoon.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 행성탐사 {
	static int R,C,N,startR,startC,endR,endC;
	static char[][] map;
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
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int row=0;row<R;row++) {
			String str = br.readLine();
			map[row] = str.toCharArray();
		}
		for(int i=1;i<=N;i++) {
			int jungle = 0; int sea = 0; int ice = 0;
			st = new StringTokenizer(br.readLine());
			startR = Integer.parseInt(st.nextToken())-1;
			startC = Integer.parseInt(st.nextToken())-1;
			endR = Integer.parseInt(st.nextToken())-1;
			endC = Integer.parseInt(st.nextToken())-1;
			for(int row=startR;row<=endR;row++) {
				for(int col=startC;col<=endC;col++) {
					if(map[row][col] == 'J') {
						jungle++;
					}else if(map[row][col] == 'O') {
						sea++;
					}else if(map[row][col] == 'I') {
						ice++;
					}
				}
				
			}
			bw.write(jungle + " " + sea + " " + ice + "\n");
		}
		bw.flush();
		bw.close();
	}
}
