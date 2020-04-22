package baekjoon.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 달팽이는올라가고싶다 {
	static int A; //up
	static int B; //down
	static int V; //height
	static int cnt = 0;
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//Scanner sc = new Scanner(System.in);
		//A = sc.nextInt(); //++2
		//B= sc.nextInt(); //--1
		//V = sc.nextInt(); //5
		//10억~ 1억 1초
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		//(길이-DOWN) / (UP-DOWN) - > cnt
		int cnt = (V-B)/(A-B);
		//몫이 0이 아니면
		if((V-B) % (A-B) != 0 ) {
			cnt++;
		}
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		//System.out.println(cnt);
	}
}
