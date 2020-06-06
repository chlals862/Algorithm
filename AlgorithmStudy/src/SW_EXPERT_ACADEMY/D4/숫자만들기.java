package SW_EXPERT_ACADEMY.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class 숫자만들기 {
	static int T,N;
	static String operator = "";
	static int[] operatorCnt;
	static int[] numbers;
	static int[] pick;
	static boolean[] visit;
	static int[] values;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		//st = new StringTokenizer(br.readLine());
		//T = Integer.parseInt(st.nextToken());

		for(int testCase=0;testCase<T;testCase++) {
			//st = new StringTokenizer(br.readLine());
			N = sc.nextInt();
			//N = Integer.parseInt(st.nextToken());
			operatorCnt = new int[N-1];
			pick = new int[N-1];
			visit = new boolean[N-1];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;

			for(int i=0;i<operatorCnt.length;i++) {
				operatorCnt[i] = sc.nextInt();
				//operatorCnt[i] = Integer.parseInt(st.nextToken());
			}
			//st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				numbers[i] = sc.nextInt();
				//numbers[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<4;i++) {
				for(int j=0;j<operatorCnt[i];j++) {
					switch(i) {
					case 0 :
						operator+="+";
						break;
					case 1 :
						operator+="-";
						break;
					case 2 :
						operator+="*";
						break;
					case 3 :
						operator+="/";
						break;
					}
				}
			}
		
		nPr(0);
		System.out.println("#"+testCase+" "+(max-min));
		}
	}
	private static void nPr(int depth) {
		if(depth ==(N-1)) {
			copy();
			calculator();
			return;
		}
		for(int i=0;i<N-1;i++) {
			if(visit[i] == false) {
				visit[i] = true;
				pick[depth] = i;
				nPr(depth+1);
				visit[i] = true;
			}
		}

	}
	private static void copy() {
		values = new int[N];
		for(int i=0;i<N;i++) {
			values[i] = numbers[i];
		}
		
	}
	private static void calculator() {
		int result = 0;
		for(int i=0;i<N-1;i++) { 
			int LV = numbers[i];
			int RV = numbers[i+1];
			
			switch (operator.charAt(pick[i])) {
			case '+' :
				result = LV + RV;
				break;
			case '-' :
				result = LV - RV;
				break;
			case '*' :
				result = LV * RV;
				break;
			case '/' :
				result = LV / RV;
				break;

			}
			values[i] = result;
		}
		result = values[N-2];
		max = Math.max(result, max);
		min = Math.min(result, min);
	}
}
