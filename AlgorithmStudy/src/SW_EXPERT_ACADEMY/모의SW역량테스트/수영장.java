package SW_EXPERT_ACADEMY.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 수영장 {
	static int T;
	static int max = Integer.MAX_VALUE;
	static int day,month,quarter,year;
	static int[] table = new int[12];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			quarter = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<table.length;i++) {
				table[i] = Integer.parseInt(st.nextToken());
			}
			logic();
			printData();
		}//testCase
		
	}
	private static void logic() {
		//1월달  <1일>,1개월,3개월,1년치
		//2월달  1일,1개월,<3개월>,1년치
		//3월달 1일,<1개월>,3개월,1년치  ....
	}
	private static void printData() {
		for(int i=0;i<table.length;i++) {
			System.out.print(table[i] + " ");
		}
		System.out.println();
	}
}
