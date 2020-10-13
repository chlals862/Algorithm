package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_1 {
	static int R,C,resultCnt,resultTime,count;
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean melt;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		resultCnt = 0;
		//처음부터 모든 치즈가 녹았을 때
//		5 5
//		0 0 0 0 0
//		0 1 1 1 0
//		0 1 0 1 0
//		0 1 1 1 0
//		0 0 0 0 0 방지용 ↓↓↓
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 1) {
					resultCnt++;
				}
			}
		}
		//'X'가 있는 쪽은 무조건 외부 공기이므로, X인 0,0에서 BFS를 돌려서 내,외부 공기 파악
		while(true) {
			//melt => 치즈가 다 녹았는지의 여부 , true ->다 녹지 않음  | false -> 다 녹음
			melt = false;
			q = new LinkedList<int[]>();
			visit = new boolean[R][C];
			q.add(new int[] {0,0});
			bfs();
			//bfs돌고 난 후 시간+1
			resultTime++;
			count = 0;
			//모든 치즈가 녹았는지 확인
			//다 녹았다면 치즈갯수 카운트
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					if(map[row][col] != 0 ) {
						melt = true;
						count++;
					}
				}
			}
			//다 녹았을 때 끝내기
			if(!melt) break;
			resultCnt = count;
		}//while
		bw.write(resultTime+"\n");
		bw.write(resultCnt+"");
		bw.flush();
		bw.close();
	}
	private static void bfs() {
		visit[0][0] = true;
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
						if(map[nr][nc] == 0 && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
					    //바깥쪽 치즈 확인
						//외부 공기에서 4방향으로 보다가 치즈[1]이 발견 되면 0으로 녹여줌 [제일 바깥쪽 치즈]
						} else if(map[nr][nc] == 1 && !visit[nr][nc]){
							map[nr][nc] = 0; //녹이기
							visit[nr][nc] = true;
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
		visit = new boolean[R][C];
		for(int row=0;row<R;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<C;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
