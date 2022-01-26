package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 쉽게푸는문제 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int sum = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int cnt = 0;
		int number = 1;
		for(int i=0;i<1000;i++) {
			arr.add(number);
			cnt++;
			//System.out.println(cnt);
			if(number == cnt) { 
				number++;
				cnt=0;
			}
		}
		
		for(int i = start; i <= end; i++) sum+= arr.get(i-1);
		bw.write(sum+" ");
		bw.flush();
		bw.close();
		//sum += box[a]+box[b];
		//System.out.println(sum);
	}
}
