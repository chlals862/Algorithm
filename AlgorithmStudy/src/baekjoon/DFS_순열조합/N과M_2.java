package baekjoon.DFS_순열조합;

import java.util.Scanner;

/*
 * 조합
 * 
 * 1 2 3 4
 * 
 * 이걸 뽑는 경우의 수 , 1 2를 뽑든 2 1 를 뽑든 같은걸로 취급함, 먼저 뭘 뽑든 상관 안함
 * 4C2 ->  n!/(n-r)!*r!
 * */
public class N과M_2 {

	static int N,M;
	static int[] pick;
	public static void main(String[] args) {
		
		setData();
		dfs(1,0);

	}
	private static void dfs(int idx, int cnt) {
		if(cnt == M) {
			for(Integer result : pick) {
				System.out.print(result + " ");
			}
			System.out.println();
			return;
		}
		for(int num=idx;num<=N;num++) {
				pick[cnt] = num;
				dfs(num+1,cnt+1);
			
		}
	}
	private static void setData() {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		pick = new int[M];
	}
}
