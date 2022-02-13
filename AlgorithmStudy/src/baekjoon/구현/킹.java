package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 킹 {
	static int[] dr = {1,-1,0,0,1,-1,1,-1};
	static int[] dc = {0,0,-1,1,1,1,-1,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		String kingRC = st.nextToken();
		String stoneRC = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		int kingR = kingRC.charAt(0)-'A'+1;
		int kingC = kingRC.charAt(1)-'0';
		int stoneR = stoneRC.charAt(0)-'A'+1;
		int stoneC = stoneRC.charAt(1)-'0';
		
		for(int i=0;i<N;i++) {
			String move = br.readLine();
			int idx = 0;
			int tmpR = kingR;
			int tmpC = kingC;
			switch(move) {
			case "R" : idx = 0; break;
			case "L" : idx = 1; break;
			case "B" : idx = 2; break;
			case "T" : idx = 3; break;
			case "RT" : idx = 4; break;
			case "LT" : idx = 5; break;
			case "RB" : idx = 6; break;
			case "LB" : idx = 7; break;
			}
			tmpR += dr[idx];
			tmpC += dc[idx];
			if(tmpR >= 1 && tmpR <= 8 && tmpC >= 1 && tmpC <=8) {
				if(tmpR == stoneR && tmpC == stoneC) {
					if(stoneR+dr[idx]>= 1 && stoneR+dr[idx] <= 8 && stoneC+dc[idx] >= 1 && stoneC+dc[idx] <= 8) {
						stoneR += dr[idx];
						stoneC += dc[idx];
					}else {
						continue;
					}
				}
				kingR = tmpR;
				kingC = tmpC;
			}
		}
		kingRC = "";
		stoneRC = "";
		
		kingRC += Character.toString((char)(kingR+'A'-1))+kingC;
		stoneRC += Character.toString((char)(stoneR+'A'-1))+stoneC;
		bw.write(kingRC+"\n"+stoneRC);
		bw.flush();
		bw.close();
		//System.out.println(kingR+ " " + kingC);
		//System.out.println(stoneR + " " + stoneC);
	}

}
