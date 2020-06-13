package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인구이동 {
	static int N;
	static int num = 1;//연합번호
	static int L,R;
	static int[][] map;
	static int[][] border;
	static boolean flag;
	static boolean[][] visit;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		border = new int[N][N];
		visit = new boolean[N][N];
		for(int row=0;row<N;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<N;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		/*
		 * 연합을 맺고 국경선을 여는게 언제 끝날지 모르는데?
		 * 언제끝날지 모르니 일단 계속 반복하다가 더이상 국경선 못여는 시점에 끝내야하지않을까??
		 * 언제끝날지 모를떄 ~~~~~ 로 일단 하라고 했떤거 기억해서 여따 코드 추가
		 * 
		 * step1 -> step2 -> step1 - step2 ->...............->>.....
		 * 언제끝날까? -> while(true) {
		 */
		
		
		
		/*
		 * Step 1.
		 * 국경선 오 -> 1 //닫 0
		 * 선택된 국경으로부터 연합조건에 맞는 인접한 국가들 연합 맺어주기.
		 * 단지번호 붙이기마냥 연합 맺으면서 연합 구성
		 */
		
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				//소속된 연합이 없다면 이 칸에 대해서 bfs를 통해 국경선 조사 및 연합 구성, 1번 연합이라고 씀
				//bfs 탐색으로 현재 칸에 대해 연합조사가 끝났으니 다음 연합 번호는 2,3,4,,,.....
				if(border[row][col] == 0 && !visit[row][col]) {//연합을 가지지 않은 국가 조사
					flag = false;
					insertQueue(row,col);
					border[row][col] = num;
					BFS(num);
					num++;
				}
				//만약 어떤 연합도 이루지 않았다, 즉 bfs 탐색을 통해 국경선을 한번도 연적이 없다. 모든 칸을 조사했는데도.
				//그럼 여기서 끝
				if(!flag) break;
			}
		}
		//view();
		
		//아니라면 step 2 진행
		
		
		/*
		 * Step 2.
		 * 구성한 연합들, 즉 1번연합, 2번연합.. 등등 
		 * 같은 연합 가진 국가들에 대해서 인구이동처리 
		 * -> 연합의인구수/연합을 이루고 있는 칸의 개수 
		 */
		
		// border 맵에 연합 정보가 전부 구성이 되어있을 것임
		// 여기서 border 맵을 참조해서 people맵을 update
		// 즉 같은 연합 이룬 애들 칸에 전부 (연합의인구수/연합을 이루고있는 칸의 개수) 적용
		//즉 ,예를들어 1번 연합들의 총인구수는  500명, 칸의 개수 5라면 1번 연합애들의 인구수는 전부 100
		// 2번 연합의 총인구수는 400명 / 칸의 개수는 8이라면 2번 연합으로 표시된 people 맵에 전부 50명으로 update
		
		//새로운 people맵이 잘 적용됐는지 찍어보기
		
		
	}

	private static void insertQueue(int row, int col) {
		q.add(new int[] {row,col});
		visit[row][col] = true;
	}
	//국경선 조사 후 연합 맺기
	private static void BFS(int num) { 
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				//4방향 
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					//맵을 벗어나지 않고
					if(rangeCheck(nr,nc)) {
						//현재 국가와 인접한 국가의 인구수가 L이상 R이하 + 탐색하지 않은 곳이면
						System.out.println("range = "+ Math.abs(map[cr][cc] - map[nr][nc])); 
						if(Math.abs(map[cr][cc] - map[nr][nc]) >= L && Math.abs(map[cr][cc] - map[nr][nc] ) <= R && !visit[nr][nc]) {
							flag = true;
							insertQueue(nr, nc);
							border[nr][nc] = num;
						}
					}
				}
			}
			//num++;
			view();
		}
		
	}

	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc< N) return true;
				return false;
	}

	private static void view() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(border[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
