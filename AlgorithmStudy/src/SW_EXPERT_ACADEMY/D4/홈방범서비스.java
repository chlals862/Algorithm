package SW_EXPERT_ACADEMY.D4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//운영 비용 = K * K + (K - 1) * (K - 1)
//N -> 도시크기, M -> 하나의 집이 지불할 수 있는 비용
//보안회사의 이익 = 서비스 제공받는 집들을 통해 얻는 수익(M*집의 수) - 운영 비용
//이때, 손해를 보지 않으면서 홈방범 서비스를 가장 많은 집들에 제공하는 서비스 영역을 찾고,
//그 때의 홈방범 서비스를 제공 받는 집들의 수를 출력하는 프로그램을 작성하라.

//1은 집 , 0은 빈칸
//K = 1  1 
//K = 2  5     +4
//K = 3  13    +8
//K = 4  25... +12
//K는  (BFS 횟수 -1) + 4
public class 홈방범서비스 {
	static int T,K,N,M,cost,houseCount,result;
	static int[][] city;
	static int[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int companyProfit; // companyProfit = M * 집수(houseCount) - cost
	static int serviceArea;
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) {
		inputdata();

	}

	private static void inputdata() {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt(); //테스트 케이스

		for(int test=0;test<T;test++) {
			N = sc.nextInt(); //도시 크기
			M = sc.nextInt(); //집의 지불 비용
			city = new int[N][N];
			visit = new int[N][N];

			for(int row=0;row<N;row++) {
				for(int col=0;col<N;col++) {
					city[row][col] = sc.nextInt();
				}
			}
			//한칸씩 확인
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					//서비스 영역
					for(int k=1;k<=10;k++) {
						q.add(new int[] {i,j});
						visit[i][j] = 1;
						BFS(i,j,k);		
						//색칠이 끝났어
						//visit[색칠 끝난애]랑 city랑 비교하면서 갱신하자
						
					}

				}
			}

		}//testCase
	}

	private static void BFS(int i, int j, int k) {//색칠
		//visit = new boolean[N][N];
		int count = 0;
		
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			for(int s=0; s<size; s++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				
				//4방향
				for(int dir=0;dir<4;dir++) {  
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
  
					if(rangeCheck(nr,nc)) {
						//색칠되어있고 1이면
						//if(city[nr][nc] == 1 && visit[i][j] == true)
					}
				}
			}

			count++;
			System.out.println("count"+count);
			view();
		}
	}


	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
		return false;
	}

	private static void view() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				for(int k=1;k<=10;k++) {
				System.out.print(visit[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
		}
	}
}
