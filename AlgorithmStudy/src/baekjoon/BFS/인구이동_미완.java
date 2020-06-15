package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인구이동_미완 {
	static int N;
	static int time;
	static int num;//연합번호
	static int L,R;
	static int count,sum,result;//연합을 맺은 국가의 수, 연합의 인구 수
	static int[][] map;
	static int[][] border;
	static boolean flag;
	static boolean[][] visit;
	static List<Integer> list;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
		list = new ArrayList<Integer>();
		for(int row=0;row<N;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<N;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		/* num = 연합번호
		 * count = 연합에 속한 국가 수
		 * sum = 각 연합의 총 인구 수
		 * */
		
		
	/*
	 * 3 5 10
	 *  5 16 27
	 * 15 26 37
	 * 25 36 47
----------------------------
	 * 1연합		2연합		3연합
국가수            3		  3       3
인구 합         45       78     111
인구이동       15       26      37
	 * */	
	while(true) {
		num = 1;//연합번호
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				
				flag = false;
				count = 1; //국가 수
				union(row,col);//연합 구성
				logic(row,col);//인구이동
				System.out.println("row = " + row + " col = " + col);
				System.out.println("연합정보  = " + border[row][col]);
				//System.out.println("국가 수 = " + count);
				//System.out.println("인구");
				view2();
			}
		}
		System.out.println("연합 정보");
		view();
		if(flag == false) break;
	
	}//while

	}
	
	
	//연합별 총 인구수/국가수 -> result
	//-> map에 update
	//인구 이동
	private static void logic(int row, int col) {
		
		if(border[row][col] == num-1) {
			System.out.println((num-1) + "==" + border[row][col]);
			map[row][col] = result;
		}
	}
	//연합구성
	private static void union(int row, int col) {
		if(border[row][col] == 0) {//연합을 가지지 않은 국가 조사
			sum = map[row][col];//sum = 현재국가
			insertQueue(row,col);//현재 국가를 q에 넣고 bfs돌려서 연합 생성
			border[row][col] = num; //현재 국가는 연합1로 시작
			BFS(num);
			num++;//bfs한번 끝나고 bfs에 해당하지 않은 국가는 연합++;
			list.add(count);
			System.out.println(border[row][col]+" 연합");
			System.out.println("합 = " + sum);
			System.out.println("인구이동 = " + result);
		}
	}

	//국경선 조사 후 연합 맺기
	//BFS쪽은 문제가 없는 듯
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
						if(Math.abs(map[cr][cc] - map[nr][nc]) >= L && Math.abs(map[cr][cc] - map[nr][nc] ) <= R && visit[nr][nc] == false) {
							flag = true;
							insertQueue(nr, nc);
							border[nr][nc] = num;
							count++;
							sum += map[nr][nc];
						
						} 
					}
				}
			}
			result = (int)Math.floor(sum/count);
			view2();
		}
	}

	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
				return false;
	}

	private static void insertQueue(int row, int col) {
		q.add(new int[] {row,col});
		visit[row][col] = true;
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
	private static void view2() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
