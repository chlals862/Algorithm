package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질 {

	static int Csubin;
	static int Ctarget;
	static int time;
	static int answer;
	static boolean[] visit= new boolean[100001];
	static Queue<Integer> que = new LinkedList<Integer>();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Csubin = sc.nextInt();
		Ctarget = sc.nextInt();
		
	
		insertQueue(Csubin);
	
		BFS();
		System.out.println(answer);
	}
	private static void BFS() {
		time = 0;
		while(!que.isEmpty()) {
			
			int size = que.size();
			
			for(int i=0;i<size;i++) {
				
				int currentPS = que.poll();
				
				if(currentPS == Ctarget) {
					answer = time;
					return;
				}else {
					int nextPosition = currentPS-1;
					if(rangeCheck(nextPosition) && visit[nextPosition] == false) {
						insertQueue(nextPosition);
					}
					nextPosition = currentPS + 1;
					if(rangeCheck(nextPosition) && visit[nextPosition] == false) {
					insertQueue(nextPosition);
						
					}
					nextPosition = currentPS * 2;
					if(rangeCheck(nextPosition) && visit[nextPosition] == false) {
						insertQueue(nextPosition);
					}
					
				}
			}
			time++;
			
		}
		
	}
	private static boolean rangeCheck(int nextPosition) {
		if(nextPosition >= 0 && nextPosition <= 100000) {
			return true;
		}
		return false;
	}
	private static void insertQueue(int Csubin) {
		que.add(Csubin);
		visit[Csubin] = true;
		
	}
}
