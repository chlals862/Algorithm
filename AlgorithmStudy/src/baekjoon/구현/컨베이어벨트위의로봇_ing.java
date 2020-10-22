package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇_ing {
	static int N, K, count, hpCnt;
	static boolean end;
	static int[] belt; // 내구도
	static int[] robot; // 로봇 위치
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
		rotation();
	}

	private static void rotation() {
		count = 0;
		System.out.println("K = " + K);
		while (true) {
			end = false;

			int hpCnt = 1;
			System.out.println("Count 증가");
			count += 1; // 단계
			// 1.벨트가 한 칸 회전
			int temp = belt[2 * N];
			//int rTemp = robot[2 * N];
			for (int row = 2 * N; row >= 1; row--) {
				belt[row] = belt[row - 1];
				//robot[row] = robot[row - 1];
			}
			belt[1] = temp;
			//robot[1] = rTemp;
			System.out.println("회전후 ");
			printMap();
			printMap2();
			// 올라가는 경우 해당 칸 내구도 1 감소
			if (belt[1] > 0 && robot[1] == 0) {
				robot[1] = 1;
				belt[1] -= 1;
			}
			System.out.println("올라오는 곳 내구도 감소 후");
			printMap();
			printMap2();
			// 2.
			for (int row = 1; row <= 2 * N; row++) {
				if (row + 1 < 2 * N) {
					if (robot[row] == 1 && robot[row + 1] == 0 && belt[row + 1] > 0) {
						System.out.println("case 2 이동");
						robot[row + 1] = robot[row];
						if(row == 2*N && robot[2*N] == 1) {
							System.out.println("로봇 내려가기");
							robot[2*N] = 0;
						}
						if (belt[row + 1] > 0) {
							System.out.println("로봇 이동 후 내구도 깎기");
							belt[row + 1] -= 1;
							printMap();
							printMap2();
						}
					} else
						System.out.println("이동 못할 경우 제자리");
						robot[row] = robot[row];
				}
			}
			System.out.println("case 2");
			printMap();
			printMap2();
			// 3.
			if (belt[1] > 0 && robot[1] == 0) {
				System.out.println("로봇 올라가기");
				robot[1] = 1;
				belt[1] -= 1;
			}
			System.out.println("case 3");
			printMap();
			printMap2();
			// 4.
			for (int row = 1; row < 2 * N; row++) {
				if (belt[row] == 0) {
					hpCnt++;
					System.out.println("hpCnt = " + hpCnt + " K = "+ K);
					if(hpCnt >= K) {
						end = true;
					}
				}
			}
			if(end) break;
			System.out.println("카운트 = " + count);
		}
		
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2 * N + 1];
		robot = new int[2 * N + 1];
		st = new StringTokenizer(br.readLine());
		for (int row = 1; row <= 2 * N; row++) {
			belt[row] = Integer.parseInt(st.nextToken());
		}
		for (int row = 1; row <= 2 * N; row++) {
			robot[row] = 0;
		}
		// printMap();
	}

	private static void printMap() {
		for (int row = 1; row < belt.length; row++) {
			System.out.print(belt[row] + " ");
		}
		System.out.println();
	}

	private static void printMap2() {
		for (int row = 1; row < belt.length; row++) {
			System.out.print(robot[row] + " ");
		}
		System.out.println();
	}

}
