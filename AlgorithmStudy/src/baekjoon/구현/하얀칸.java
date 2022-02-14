package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 하얀칸 {
	static char[][] map;
	static int cnt;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		//st = new StringTokenizer(br.readLine());
		map = new char[8][8];
		for(int row=0;row<8;row++) {
			String str = br.readLine();
			map[row] = str.toCharArray();
		}
		
		for(int row=0;row<8;row++) {
			for(int col=0;col<8;col++) {
				if(map[row][col] == 'F' && (row+col) % 2 == 0) cnt++;
			}
		}
		bw.write(cnt+"");
		bw.flush();
		bw.close();
	}

}
