package SW_EXPERT_ACADEMY.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소탈출 {
	static int T, R, C,answer;
	static int[][] map;
	static boolean[][] sVisit;
	static boolean[][] vVisit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<SV> q = new LinkedList<SV>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static boolean flag;
	static boolean die;

	static class SV {
		int sRow;
		int sCol;
		int vRow;
		int vCol;
		int id;

		public SV(int sRow, int sCol, int vRow, int vCol, int id) {
			this.sRow = sRow;
			this.sCol = sCol;
			this.vRow = vRow;
			this.vCol = vCol;
			this.id = id;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		setData();
	}

	private static void setData() throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			sVisit = new boolean[R][C];
			vVisit = new boolean[R][C];
			q.clear();
			flag = false;
			die = false;
			ArrayList<SV> list = new ArrayList<SV>();
			for(int row=0;row<R;row++) {
				st = new StringTokenizer(br.readLine());
				for(int col=0;col<C;col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
					if(map[row][col] == 3) {
						list.add(new SV(row, col, -1, -1, 1));
						sVisit[row][col] = true;
					}
					else if(map[row][col] == 2) {
						list.add(new SV(-1, -1, row, col, 2));
						vVisit[row][col] = true;
					}
				}
			}
			
			Collections.sort(list,  new Comparator<SV>() {
				@Override
				public int compare(SV o1, SV o2) {
					return Integer.compare(o1.id, o2.id);
				}
			});
			
			for(int i=0;i<list.size();i++) {
				q.add(list.get(i));
			}
			BFS();
			
			if(flag) {
				bw.write("#"+t+" "+ answer+"\n");
			}else if(!flag && !die) {
				bw.write("#"+t+" "+"CANNOT ESCAPE"+"\n");
			}else if(die && !flag) {
				bw.write("#"+t+" "+"ZOMBIE"+"\n");
			}
		}
		bw.flush();
	}

	private static void BFS() {
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				SV current = q.poll();
				switch(current.id) {
				case 1:
					if(!vVisit[current.sRow][current.sCol]) {
						sMove(current);
						if(flag) {
							time++;
							answer = time;
							return;
						}
					}
				case 2: 
					vMove(current);
					break;
				}
			}
			time++;
		}
		
	}

	private static void vMove(SV current) {
		int cr = current.vRow;
		int cc = current.vCol;
		for(int dir=0;dir<4;dir++) {
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			if(rangeCheck(nr,nc) && !vVisit[nr][nc] && map[nr][nc] == 0) {
				q.add(new SV(-1, -1, nr, nc, 2));
				vVisit[nr][nc] = true;
				map[nr][nc] = 2;
			} else if(rangeCheck(nr,nc) && !vVisit[nr][nc] && map[nr][nc] == 3) {
				q.add(new SV(-1, -1, nr, nc, 2));
				vVisit[nr][nc] = true;
				map[nr][nc] = 2;
				die = true;
			}
		}
		
	}

	private static void sMove(SV current) {
		int cr = current.sRow;
		int cc = current.sCol;
		for(int dir=0;dir<4;dir++) {
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			if(rangeCheck(nr,nc) && !sVisit[nr][nc] && map[nr][nc] == 0) {
				q.add(new SV(nr, nc, -1, -1, 1));
				sVisit[nr][nc] = true;
			}else if(!rangeCheck(nr,nc)) {
				flag = true;
				return;
			}
		}
		
	}

	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}

	private static void printData() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
