package CodeUp;

import java.util.Scanner;

public class Test {
//		생명 게임은 25×25 격자에서 하는 게임이다.
//		각 칸에는 최대 1마리의 생명이 존재 할 수 있으며, 한 "세대"가 지날때 마다 생명이 탄생하거나 죽는다.
//		생명이 탄생하거나 죽는 조건은 다음과 같다:
//		1. 생명이 없는 칸의 주위 8칸에 정확히 3마리의 생명이 존재하는 경우 다음 세대에 그 칸에서 생명이 탄생한다.
//		2. 생명이 있는 칸의 주위 8칸에 4마리 이상 또는 1마리 이하의 생명이 존재하는 경우 다음 세대에 그 칸의 생명은 죽는다.
//		3. 생명이 있는 칸의 주위 8칸에 2마리 또는 3마리의 생명이 존재하는 경우 다음 세대에 그 칸의 생명은 생존한다.
//		25×25 격자의 생명의 위치가 주어질 때, 다음 세대의 모습을 출력하시오.
//		25x25격자 정보가 입력된다. 총 25행, 25열이 입력된다.
//		생명이 있는 경우 1, 생명이 없는 경우 0으로 표시하며, 각 정보는 띄어쓰기로 구분된다.
	static int[][] now = new int[25][25];
	static int[][] next = new int[25][25];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < now.length ; i++) {
			for(int j = 0 ; j < now[i].length ; j++) {
				now[i][j] = sc.nextInt();
			}
		}
		
		next();
		
		// 다음 세대
		for(int[] a : next) {
			for(int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}
	
	public static void next() {
		for(int i = 0 ; i < now.length ; i++) { // y
			for(int j = 0 ; j < now[i].length ; j++) { // x
				int cnt = 0;
				
				for(int k = -1 ; k < 2 ; k++) { // y
					for(int z = - 1 ; z < 2 ; z++) { // x
						if(i + k > -1 && i + k < 25 && j + z > -1 
								&& j + z < 25 && now[i + k][j + z] == 1) {
							if(k != 0 || z != 0) {
								cnt++;
							}
						}
					}
				}
					
				if(now[i][j] == 0 && cnt == 3) {
					next[i][j] = 1;
				} else if(now[i][j] == 1 && (cnt >= 4 || cnt <= 1)) {
					next[i][j] = 0;
				} else if(now[i][j] == 1 && (cnt >= 2 && cnt <= 3)) {
					next[i][j] = 1;
				} else {
					next[i][j] = 0;
				}
			}
		}
	}
}
