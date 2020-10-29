package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇 {
	static int N, K, count;
	static int[] belt; // 내구도
	static int[] robot; // 로봇 위치
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		while (true) {
			//로봇 회전
			for (int row = N-1;row>0;row--) {
				if(robot[row] == 1) {
					robot[row+1] = 1;
					robot[row] = 0;
				}
			}
			robot[N] = 0;//로봇 내려감
			//벨트 회전
			int temp = belt[2*N];
			for(int row=2*N;row>1;row--) {
				belt[row] = belt[row-1];
			}
			belt[1] = temp;
			//로봇 이동 시키기
			for(int row=N-1;row>0;row--) {
				//현재 칸에 로봇이 있고 다음칸에 로봇이 없고,다음칸 벨트 내구도가 0보다 클 때
				if(robot[row] == 1 && robot[row+1] == 0 && belt[row+1] > 0 ) {
					//현재칸의 로봇은 다음칸으로 이동했으니 로봇 위치 스왑해주고, 다음칸 내구도 깎기
					robot[row+1] = 1;
					robot[row] = 0;
					belt[row+1]--;
				}
			}
			robot[N] = 0; //로봇 내려감
			//올라가는 곳에 로봇이 없고, 내구도가 1이상이면 로봇 올리고 내구도 깎기
			if(robot[1] == 0 && belt[1] > 0 ) {
				robot[1] = 1;
				belt[1]--;
			}
			if(countZero() >= K) break;
			count++;
		}
		bw.write(count+"\n");
		bw.flush();
		bw.close();
	}
	
	private static int countZero() {
		int result = 0;
		for(int row=1;row<=2*N;row++) {
			if(belt[row]==0) result++;
		}
		return result;
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2*N+1];
		robot = new int[2*N+1];
		count = 1;
		st = new StringTokenizer(br.readLine());
		for (int row = 1; row <= 2 * N; row++) {
			belt[row] = Integer.parseInt(st.nextToken());
		}
	}
}
