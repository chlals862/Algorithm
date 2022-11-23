package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1652 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		
		for(int row=0;row<N;row++) {
			String str = br.readLine();
			for(int col=0;col<N;col++) {
				map[row][col] = str.charAt(col);
			}
		}
		
		int resultR = 0;
		int resultC = 0;
		
		for(int i=0;i<N;i++) {
			int row = 0;
			int col = 0;
			for(int j=0;j<N;j++) {
				if(map[i][j] == '.') 
					row++;
				if(map[i][j] == 'X' || (j == N-1)) {
					if(row >= 2) resultR++;
					row = 0;
				}
				if(map[j][i] == '.') 
					col++;
				if(map[j][i] == 'X' || (j == N-1)) {
					if(col >= 2) resultC++;
					col = 0;
				}
			}
		}
		
		
		bw.write(resultR + " " + resultC+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
