package SW_EXPERT_ACADEMY.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 미로1_DFS {
	static int num;
	static int[][] map;
	static boolean[][] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken());
		for(int t=1;t<10;t++) {
			map = new int[16][16];
			visit = new boolean[16][16];
			
			for(int row=0;row<16;row++) {
				st = new StringTokenizer(br.readLine());
				for(int col=0;col<16;col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			printData();
			
		}
		
		
	}
	private static void printData() {
		for(int row=0;row<16;row++) {
			for(int col=0;col<16;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
