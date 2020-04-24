package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//5시간 , 지문 변수들의 범위를 잘 보기, flag변수를 잘 이용하자...
public class 스타트링크 {
	static int count, nu, nd;
	static int F, S, G, U, D;
	static boolean[] visit;
	static boolean flag;
	static Queue<Integer> q = new LinkedList<Integer>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		F = sc.nextInt();// 빌딩높이
		S = sc.nextInt();// 강호시작점
		G = sc.nextInt();// 목표층
		U = sc.nextInt();// 엘리베이터 위로
		D = sc.nextInt();// 엘리베이터 아래로
		count = 0;

		visit = new boolean[F + 1];
		q.add(S);
		visit[S] = true;
		BFS();

		if(flag) {//true면
			System.out.println(count);
		} else {
			System.out.println("use the stairs");
		}
	}

	private static void BFS() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int current = q.poll();

				if (current == G) {
					flag = true;
					return;
				}
				nu = current + U;
				nd = current - D;
				if (rangeCheck(nu) && visit[nu] == false) {

					q.add(nu);
					visit[nu] = true;
				}
				if (rangeCheck(nd) && visit[nd] == false) {

					q.add(nd);
					visit[nd] = true;
				}
			}
			count++;
		}
	}
	private static boolean rangeCheck(int nu) {
		if (nu >= 1 && nu <= F) { //문제에서 F,S,G는 1부터 시작 
			return true;
		}
		return false;
	}

}
