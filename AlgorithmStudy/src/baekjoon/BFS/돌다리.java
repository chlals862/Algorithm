package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 돌다리 {
	static int A,B,N,M,jump;
	static int result;
	static boolean[] visit = new boolean[100001];
	static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextInt(); //콩콩이 힘 1
		B = sc.nextInt(); //콩콩이 힘2
		N = sc.nextInt(); //동규 현위치
		M = sc.nextInt(); //주미 현위치
		jump = 0;
		q.add(N);
		visit[N] = true;
		
		BFS();
		System.out.println(jump);
		
	}
	private static void BFS() {
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0;i<size;i++) {
				int current = q.poll();
				
				if(current == M) {	
					result = jump;
					return;
				} else {
					//-1 +1 A,B, current*A , current*B
					int np = current-1;
					if(rangeCheck(np) && visit[np] == false) {
						q.add(np);
						visit[np] = true;
					}
					np = current+1;
					if(rangeCheck(np) && visit[np] == false) {
						q.add(np);
						visit[np] = true;
					}
					np = current+A;
					if(rangeCheck(np) && visit[np] == false) {
						q.add(np);
						visit[np] = true;
					}
					np = current+B;
					if(rangeCheck(np) && visit[np] == false) {
						q.add(np);
						visit[np] = true;
					}
					np = current-A;
					if(rangeCheck(np) && visit[np] == false) {
						q.add(np);
						visit[np] = true;
					}
					np = current-B;
					if(rangeCheck(np) && visit[np] == false) {
						q.add(np);
						visit[np] = true;
					}
					np = current*A;
					if(rangeCheck(np) && visit[np] == false) {
						q.add(np);
						visit[np] = true;
					}
					np = current*B;
					if(rangeCheck(np) && visit[np] == false) {
						q.add(np);
						visit[np] = true;
					}
				}
			}
			jump++;
		}
		
	}
	private static boolean rangeCheck(int np) {
		if(np >= 0 && np <= 100000) {
			return true;
		}
		return false;
	}
}
