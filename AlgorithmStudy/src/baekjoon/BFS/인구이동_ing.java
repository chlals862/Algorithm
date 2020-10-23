package baekjoon.BFS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class 인구이동_ing {
	static int N, low, high,moveCount;
	static int unionNum;
	static int[][] map;
	static int[][] union; // 0-> 국경선 닫기, 1-> 국경선 열기
	static boolean[][] visit;
	static boolean[][] unionVisit;
	static Queue<int[]> q;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean move;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() {
		//while (true) {
		q = new LinkedList<int[]>();
		visit = new boolean[N][N]; // 방문
		union = new int[N][N]; // 연합
		unionVisit = new boolean[N][N];
		move = false; // 인구이동
		open(); // 국경선 열기
		if(move) {
		move();
		moveCount+=1;
		}
		printMap();
		// if(!move) break; //인구이동이 더 이상 없을 떄 종료
		// }
		System.out.println(moveCount);
	}
	private static void move() {
		//각 연합마다 인구이동
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(!unionVisit[row][col]) {
					int count = 1;
					int sum = map[row][col];
					q.add(new int[] {row,col});
					unionVisit[row][col] = true;
					unionMove(count,sum);
				}
			}
		}
		printMap();
	}
	private static void unionMove(int count, int sum) {
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
						if(union[cr][cc] == union[nr][nc] && !unionVisit[nr][nc]) {
							count++;
							sum += map[nr][nc];
							q.add(new int[] {nr,nc});
							unionVisit[nr][nc] = true;
						}
					}
				}
			}
			
		}
	}
	private static void open() {
		int unionNum = 1;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (!visit[row][col]) {
					q.add(new int[] { row, col });
					visit[row][col] = true;
					union[row][col] = unionNum;
					union(unionNum);
					unionNum++;
				}
			}
		}
		System.out.println("연합 후");
		printMap2();
	}
	private static void union(int unionNum) {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (rangeCheck(nr, nc) ) {
						int con = Math.abs(map[cr][cc] - map[nr][nc]);
						if (con >= low && con <= high && !visit[nr][nc]) {
							union[nr][nc] = unionNum;
							q.add(new int[] { nr, nc });
							visit[nr][nc] = true;
							move = true;
						}
					}
				}
			}
			//printMap2();
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N)
			return true;
		return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		low = Integer.parseInt(st.nextToken());
		high = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < N; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
	private static void printMap() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void printMap2() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				System.out.print(union[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
