package CodeUp.조건문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1222 {
	static int time,score1,score2;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		time = Integer.parseInt(st.nextToken());
		score1 = Integer.parseInt(st.nextToken());
		score2 = Integer.parseInt(st.nextToken());
		
		while(time<90) {
			score1++;
			time+=5;
		}
		if(score1 == score2) {
			bw.write("same"+"");
		}else if(score1 < score2) {
			bw.write("lose");
		}else if(score1 > score2) {
			bw.write("win");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
