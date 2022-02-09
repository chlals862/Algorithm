package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Knight_ing {
	static int[] dr = {-2,-2,-1,1,2,2,1,-1};
	static int[] dc = {-1,1,2,2,1,-1,-2,-2};
	static int[][] map;
	static boolean[][] visit;
	static int startR,startC,endR,endC,count;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		//st = new StringTokenizer(br.readLine());
		String startRC = br.readLine();
		String endRC = br.readLine();
		//startR = startRC.charAt(0)-97;
		//startC = startRC.charAt(1)-'1';
		//endR = endRC.charAt(0)-97;
		//endC = endRC.charAt(1)-'1';
		
		if(startRC.charAt(0) == 'a') {
			startC = 0; endC = 0;
		}
		else if(startRC.charAt(0) == 'b') {
			startC = 1; endC = 1;
		}
		else if(startRC.charAt(0) == 'c') {
			startC = 2; endC = 2;
		}
		else if(startRC.charAt(0) == 'd') {
			startC = 3; endC = 3;
		}
		else if(startRC.charAt(0) == 'e') {
			startC = 4; endC = 4;
		}
		else if(startRC.charAt(0) == 'f') {
			startC = 5; endC = 5;
		}
		else if(startRC.charAt(0) == 'g') {
			startC = 6; endC = 6;
		}
		else if(startRC.charAt(0) == 'h') {
			startC = 7; endC = 7;
		}
		
		if(startRC.charAt(1) == '1') {
			startR = 7; endR = 7;
		}
		else if(startRC.charAt(1) == '2') {
			startR = 6; endR = 6;
		}
		else if(startRC.charAt(1) == '3') {
			startR = 5; endR = 5;
		}
		else if(startRC.charAt(1) == '4') {
			startR = 4; endR = 4;
		}
		else if(startRC.charAt(1) == '5') {
			startR = 3; endR = 3;
		}
		else if(startRC.charAt(1) == '6') {
			startR = 2; endR = 2;
		}
		else if(startRC.charAt(1) == '7') {
			startR = 1; endR = 1;
		}
		else if(startRC.charAt(1) == '8') {
			startR = 0; endR = 0;
		}
		
		count = 0;
		map = new int[9][9];
		visit = new boolean[9][9];
		Queue<int[]> q = new LinkedList<int[]>();

		
		q.add(new int[] {startR,startC});
		visit[startR][startC] = true;
		//System.out.println(startR + " " + startC);
		//System.out.println(endR + " " + endC);
		//map[startR][startC] = 1;
		
		
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<8;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(!visit[nr][nc]) {
							if(nr == endR && nc == endC) return;
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
						}
					}
				}
			}
			count++;
		}
		for(int row=0;row<8;row++) {
			for(int col=0;col<8;col++) {
				System.out.print(visit[row][col]+ " ");
			}
			System.out.println();
		}
		if(startRC == endRC) bw.write(0+"");
		else bw.write(count+"\n");
		bw.flush();
		bw.close();
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < startR && nc >= 0 && nc < startC) return true;
			return false;
	}

}
