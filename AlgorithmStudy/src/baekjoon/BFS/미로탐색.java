package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색 {

	static int N;
	static int M;
	static char[][] Map;//map 이 1 or 0 이므로 char로
	static boolean[][] visitMap;
	static int[] dr = {-1,0,1,0};// 상  우  하  좌 
	static int[] dc = {0,1,0,-1};// 상  우  하  좌 
	static int count;
	static Queue<int[]> q = new LinkedList<int[]>(); 
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();//행
		M = sc.nextInt();//렬
	
		//Map과 vistiMap 생성
		Map = new char[N][M];
		visitMap = new boolean[N][M];
		count = 1;
		sc.nextLine();//? 1
		//알아보기 쉽게 row로 ,row 한줄씩 읽음
		for(int row=0;row<N;row++) {
			String sLine = sc.nextLine();
			//미로 1,0값을 하나씩 쪼개서 row에 넣음
			Map[row] = sLine.toCharArray();
		}	
		view();
		//시작점 0,0을 추가하고, true로 바꿔주자 -> 0,0은 방문한걸로 
		//false - > 방문X , true -> 방문 O
		q.add(new int[] {0,0});
		visitMap[0][0] = true;
		//bfs돌리는 함수
		//bfs();
		System.out.println(count);
	}

	private static void view() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<M;col++) {
				System.out.print(Map[row][col]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void bfs() {
		while(!q.isEmpty()) {//비어있지 않을때까지 반복
			count++;//? 2
			int size = q.size(); //for문에 대입하면 size가 바뀔수 있으니 처음에 원하는 반복문 수만큼 돌리질 못함
			for(int i=0;i<size;i++) {//1개씩          		                //0 1
				int[] currentRC = q.poll(); //처음에 -> currentRC[] -> {0,0} 
				for(int dir = 0; dir < 4; dir++) { //4방향
					int nr = currentRC[0] + dr[dir]; //-1,0,1,0
					int nc = currentRC[1] + dc[dir]; //0,1,0,-1
					if(rangeCheck(nr,nc)) { //상,우,좌,하의 범위체크
						if(Map[nr][nc] == '1' && visitMap[nr][nc] == false) { //범위에 속한것이 1이거나 false일때 수행 , 
																			  //true는 검사한곳,0은 장애물
							if(nr == N-1 && nc == M-1) { //행,열의 끝이 nr,nc와 일치하면 종료
								return;
							}
							q.add(new int[] {nr,nc});//아니라면 q에 nr,nc를 넣음
							visitMap[nr][nc] = true;
						}
					}
				}
			}
		}//while
	}//bfs
	private static boolean rangeCheck(int nr,int nc) {
		//범위 검사 -> 입력한 행[N]열[M]안에 있는지, 0보다 커야함
		if(nr >= 0 && nr <= N-1 && nc >= 0 && nc <= M-1) {
			return true;
		}else
			return false;
	}
}
