package baekjoon.문자열처리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 세로읽기 {
	static char[][] map;
	static ArrayList<String> list = new ArrayList<String>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		map = new char[5][15];
		for(int row=0;row<map.length;row++) {
			String str = br.readLine();
			for(int col=0;col<str.length();col++) {
				map[row][col] = str.charAt(col);
			}
		}
		for(int row=0;row<15;row++) {
			for(int col=0;col<5;col++) {
				if(map[col][row]==' ' || map[col][row] =='\0') continue;
				bw.write(map[col][row]+"");
			}
		}
		bw.flush();
		bw.close();
	}
}
