package SW_EXPERT_ACADEMY.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 파핑파핑지뢰찾기 {
	static int K, N,max,result;
	static int[][] map,memo;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0,-1,-1,1,1};
	static int[] dc = {0,1,0,-1,-1,1,1,-1};
	static Queue<int[]> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		setData();
	}
	private static void setData() throws NumberFormatException, IOException {
		K = Integer.parseInt(br.readLine());
		for (int k = 1; k <= K; k++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N]; memo = new int[N][N]; visit = new boolean[N][N];
			q = new LinkedList<int[]>();
			for(int row=0;row<N;row++) {
				String str = br.readLine();
				for(int col=0;col<N;col++) {
					if(str.charAt(col) == '.') map[row][col] = 0;
					else if(str.charAt(col) == '*') {
						map[row][col] = -1; memo[row][col] = -1; visit[row][col] = true;
					}
				}
			}
			numbering();
			memo();
			bw.write("#"+k+" "+result+"\n");
			bw.flush();
		}
		bw.close();
	}
	private static void memo() {
		int areaNum = 1;
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(map[row][col] == 0 && !visit[row][col]) {
					q.add(new int[] {row,col});
					visit[row][col] = true;
					memo[row][col] = areaNum;
					bfs(areaNum);
					areaNum++;
				}
			}
		}
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(!visit[row][col]) {
					memo[row][col] = areaNum++;
					visit[row][col] = true;
				}
			}
		}
		result = areaNum-1;
	}
	private static void bfs(int areaNum) {
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
						if(map[nr][nc] == 0 && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
							memo[nr][nc] = areaNum;
						}else if(map[nr][nc] > 0 && !visit[nr][nc]) {
							visit[nr][nc] = true;
							memo[nr][nc] = areaNum;
						}
					}
				}
			}
		}
	}
	private static void numbering() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(map[row][col] != -1) {
					for(int dir=0;dir<8;dir++) {
						int nr = row + dr[dir];
						int nc = col + dc[dir];
						if(rangeCheck(nr,nc)) {
							if(map[nr][nc] == -1) map[row][col]+=1;
						}
					}
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N)return true;
			return false;
	}
}
