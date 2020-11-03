package 프로그래머스.스킬체크;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 이 {
	//홀수 대문자 
	//짝수 소문자
	static BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		//st = new StringTokenizer(br.readLine());
		String s = br.readLine();
		String result = "";
		for(int row=0;row<s.length();row++) {
			if(s.length()%2==0) {
				result += s.toLowerCase();
			}else result += s.toUpperCase();
		}
		System.out.println(result);
	}

}
