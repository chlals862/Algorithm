package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
/*
 * 플러드 필 알고리즘 -> 다차원 배열의 어떤 칸과 연결된 영역을 찾는 알고리즘
 * 어떤 칸에서 시작해서 해당 색깔에 해당되는 칸들을 모두 탐색한 다음 대체 색으로 바꾸어 주는 식
 * 1. walls => 벽이 있는 곳은 1[true], 없는 곳은 0[false]로 설정
 * 2. 왼쪽 위부터 이동할 수 있는 공간을 플러드 필 알고리즘을 이용하여 그룹화 하는 작업을 진행[단지번호 문제에서 단지마다 번호 부여하는 것 마냥]
 * 3. walls를 하나씩 돌면서 이동할 수 있는 칸의 갯수를 세어줌. <이 떄 매번 BFS로 돌 필요가 사라짐>
 * */
//참고 https://devowen.com/253 
//countBlock() 소스 분석이 필요
public class 벽부수고이동하기4 {
	static int R,C;
	static int[][] map;
	static int groupSize[];
	static boolean[][] walls;
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		//벽이 없는 공간 그룹화 하기
		group(); 
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				bw.write(countBlock(row,col)+ "");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	private static int countBlock(int row, int col) {
		//벽인 곳은 0
		if(!walls[row][col]) return 0;
		else {
			//중복 X
			Set<Integer>set = new HashSet<Integer>();
			for(int dir=0;dir<4;dir++) {
				int nr = row + dr[dir];
				int nc = col + dc[dir];
				if(rangeCheck(nr,nc) && map[nr][nc] != 0) {
					set.add(map[nr][nc]);
					//System.out.println("set = " + set);
				}
			}
			int count = 1;
			for(int idx : set) {
				count += groupSize[idx];
				//System.out.println("Count = " + count);
			}
			return count%10;
		}
	}
	//벽 = -> -1
	private static void group() {
		q = new LinkedList<int[]>();
		int groupIdx = 1;
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (map[row][col] == 0 && !walls[row][col]) {
					map[row][col] = groupIdx;
					q.add(new int[] {row,col});
					groupBFS(groupIdx);
					groupIdx++;
				}
			}
		}
		
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(walls[row][col]) map[row][col] = 0;
			}
		}
		//각 그룹에 속해 있는 칸 수를 groupSize 배열에 넣기
		groupSize = new int[groupIdx+1];
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] != 0) groupSize[map[row][col]]++;
			}
		}
	}
	private static void groupBFS(int groupIdx) {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(map[nr][nc] == 0 && !walls[nr][nc]) {
							map[nr][nc] = groupIdx;
							q.add(new int[] {nr,nc,groupIdx});
							
						}
					}
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		walls = new boolean[R][C];
		for(int row=0;row<R;row++) {
			String[] str = br.readLine().split("");
			for(int col=0;col<C;col++) {
				map[row][col] = Integer.parseInt(str[col]);
			}
		}
		//walls  벽 : true , 벽X : false;
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 1) walls[row][col] = true;
			}
		}
	}
}
