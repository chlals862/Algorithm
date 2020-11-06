package baekjoon.시뮬레이션;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*
10101111
01111101
11001110
00000010
1
3 -1
*/
public class 톱니바퀴 {
	static int K,gearNum,direction,result;
	static int[][] gear;
	static boolean equal2,equal3,equal4;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void logic(int gearNum, int direction) {
		equal2 = true;//서로 같으면 true -> 회전X
		equal3 = true;//서로 같으면 true -> 회전X
		equal4 = true;//서로 같으면 true -> 회전X
		if(gear[1][2] != gear[2][6]) equal2 = false;
		if(gear[2][2] != gear[3][6]) equal3 = false;
		if(gear[3][2] != gear[4][6]) equal4 = false;
		check(gearNum,direction);
	}
	private static void check(int gearNum, int direction) {
		if(gearNum==1) { //첫번쨰 기어
			if(!equal2) { //첫번쨰 기어와 두번쨰 기어 극이 다른경우 
				rotation(2,direction* -1); //두번째 기어 반시계회전 //-1 * -1은 시계방향 , 1 * -1은 -1이므로 반시계
				int temp = direction * -1; //방향 저장해놓고 다른 톱니도 회전해야 할때 넣어주기
				if(!equal3) {
					rotation(3,temp*-1); //위에서 반시계 였다면 이번엔 시계방향
					temp*=-1;
					if(!equal4) rotation(4,temp*-1);
				}
			}
			//전부 해당하지 않으면 해당하는 기어넘버만 방향대로 회전하기
			rotation(gearNum,direction);
		}
		else if(gearNum==2) {
			//1번째 톱니바퀴는 2번쨰 톱니바퀴의 반대로만 돌면 되니까 temp 필요 없음
			if(!equal2) rotation(1,direction*-1);
			if(!equal3) {
				//2번,4번은 같은 방향으로 돌기 떄문에 3번째 방향을 저장 시켜놓고 
				//4번째 톱니바퀴는 저장된 방향의 반대로 돌려줌
				rotation(3,direction*-1);
				int temp = direction*-1;
				
				if(!equal4) rotation(4,temp*-1);
			}
			rotation(gearNum,direction);
		}
		//3번째 톱니바퀴
		else if(gearNum==3) {
			//2번쨰 톱니바퀴와 3번쨰 톱니바퀴가 다를 때
			if(!equal3) {
				rotation(2,direction*-1);
				int temp = direction*-1;
				//1번째 톱니바퀴와 2번쨰 톱니바퀴도 다를 때는 
				//1번쨰 톱니바퀴를 2번쨰 톱니바퀴의 반대 방향으로 회전시키기
				if(!equal2) rotation(1,temp*-1);
			}
			if(!equal4) rotation(4,direction*-1);
			rotation(gearNum,direction);
		}
		else if(gearNum==4) {
			//3번쨰 톱니바퀴와 4번쨰 톱니바퀴가 다를 경우
			if(!equal4) {
				//3번쨰 톱니바퀴를 4번쨰 톱니바퀴 반대방향으로 회전
				rotation(3,direction*-1);
				int temp = direction*-1;
				if(!equal3) {
					rotation(2,temp*-1);
					temp *= -1;
					if(!equal2) rotation(1,temp*-1);
				}
			}
			rotation(gearNum,direction);
		}
	}
	private static void rotation(int gearNum, int direction) {
		if(direction == 1) { //시계 방향
			int end = gear[gearNum][7];
			for(int col=6;col>=0;col--) {
				gear[gearNum][col+1] = gear[gearNum][col];
			}
			gear[gearNum][0] = end;
		}else if(direction == -1){ //반시계 방향
			int first = gear[gearNum][0];
			for(int col=0;col<=6;col++) {
				gear[gearNum][col] = gear[gearNum][col+1];
			}
			gear[gearNum][7] = first;
		}
	}
	private static void setData() throws IOException {
		gear = new int[5][8];
		for(int row=1;row<5;row++) {
			String[] str = br.readLine().split("");
			for(int col=0;col<8;col++) {
				gear[row][col] = Integer.parseInt(str[col]);
			}
		}
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			gearNum = Integer.parseInt(st.nextToken());
			direction = Integer.parseInt(st.nextToken());
			logic(gearNum,direction);
		}
		printData();
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
	private static void printData() {
		if(gear[1][0] == 1) result+=1;
		if(gear[2][0] == 1) result+=2;
		if(gear[3][0] == 1) result+=4;
		if(gear[4][0] == 1) result+=8;
	}
}
