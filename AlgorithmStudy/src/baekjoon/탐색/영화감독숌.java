package baekjoon.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영화감독숌 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//static int[] movie;
	static final String MOVIE_NAME = "666";
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int num = Integer.parseInt(br.readLine());
		
		System.out.println(result(num));
	}
	
	private static int result(int num) {
		int count = 0;
		int index = 0;
		
		while(count != num) {
			if(String.valueOf(++index).contains(MOVIE_NAME)) ++count;
			
		}
		//System.out.println("String.valueOf = " + String.valueOf(++index));
		return index;
	}
}
