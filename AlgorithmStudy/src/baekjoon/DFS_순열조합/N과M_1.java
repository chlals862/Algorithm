package baekjoon.DFS_순열조합;
//순열 
/*
 * 순열 ->
 * 
 * 1 2 3 4가 있을 때
 * 이걸 섞는 방법의 가지수
 * 
 * 4! -> 24개의 경우의수가 나옴
 * 
 * */
import java.util.Scanner;

public class N과M_1 {
	static int N,M;
	static int[] pick;
	static boolean[] visit;
	//static int count = 0;
	public static void main(String[] args) {
		
		setData();
		dfs(0);
		
		//System.out.println(count);
	}
	private static void dfs(int cnt) {
		if(cnt == M) {
			//count++;
			for(Integer result : pick) {
				System.out.print(result + " ");
			}
			System.out.println();
			return;
		}
		
		for(int num=1;num<=N;num++) {
			if(visit[num] == false) {
				visit[num] = true;
				pick[cnt] = num;
				dfs(cnt+1);
				visit[num] = false;
			}
		}
	}
	private static void setData() {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		pick = new int[M];
		visit = new boolean[N+1];
	}
}
