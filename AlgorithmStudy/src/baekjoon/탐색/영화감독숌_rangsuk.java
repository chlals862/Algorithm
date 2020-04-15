package baekjoon.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영화감독숌_rangsuk {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int input = Integer.parseInt(br.readLine());
		
		int num = 1;//1부터 검사
		int count = 1;//666
		
		while(true) {
			String s = Integer.toString(num);
			if(s.contains("666")) {//만약 s가 666이 포함되어있으면
				
				if(count == input) {
					System.out.println(s);
					return;
					
				} else count++;
			}
			num++; //1부터 ~~10000까지 1개씩 검사
			System.out.println("count = " + count);
			
		}//while
	}
}
