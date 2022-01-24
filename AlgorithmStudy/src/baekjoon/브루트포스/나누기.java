package baekjoon.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 나누기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		
		N = (N/100) * 100; //마지막 두자리 수를 00으로 바꾸기
		
		while(N%F != 0) N++; //딱 맞게 나누어 떨어지는 수 
		
		N%=100;
		if(N <10) bw.write("0"+N+"\n");
		else bw.write(N+"\n");
		bw.flush();
		bw.close();
	}

}
