package baekjoon.정렬;
//수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class K번째수_ING {
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<Integer> A;
	static int K;
	static int num;
	static int inputNum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		inputData();
	}
	private static void inputData() throws NumberFormatException, IOException {
		//Scanner sc = new Scanner(System.in);

		//int inputNum = sc.nextInt();// 5
		//int K = sc.nextInt();// 2
		inputNum = Integer.parseInt(br.readLine());//5
		System.out.println(inputNum);
		int K = Integer.parseInt(br.readLine());//2
		
		List<String> A = new ArrayList<>();// 5
/*
		for (int i = 0; i < inputNum; i++) {
			String num = br.readLine();
			st = new StringTokenizer(br.readLine());
			A.add(num);
			//K = Integer.parseInt(st.nextToken());
			System.out.print(A);
			System.out.println(K);
		}*/
		//Collections.sort(A);
		//System.out.println("정렬 후 = " + A);
		//로직 및 출력
		/*
		 * for (int i = 0; i < A.size(); i++) { if (K == A.indexOf(i)) {
		 * System.out.print(i-1); //} } }
		 */
	}
}
