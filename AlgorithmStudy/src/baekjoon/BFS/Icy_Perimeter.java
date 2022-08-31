package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Icy_Perimeter {
	static int num;
	static char[][] map;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());
		
		map = new char[num][num];
		for(int row=0;row<num;row++) {
			String str = br.readLine();
			for(int col=0;col<num;col++) {
				map[row] = str.toCharArray();
			}
		}
		
		
		for(int row=0;row<num;row++) {
			for(int col=0;col<num;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		
		
		
	}
}
