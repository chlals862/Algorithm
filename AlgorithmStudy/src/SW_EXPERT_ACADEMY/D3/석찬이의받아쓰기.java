package SW_EXPERT_ACADEMY.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 석찬이의받아쓰기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=TC;t++) {
			int cnt = 0;
			long length = Long.parseLong(br.readLine());
			
			String str1 = br.readLine();
			String str2 = br.readLine();
			
			for(int i=0;i<length;i++) {
				if(str1.charAt(i) == str2.charAt(i)) {
					cnt++;
				}
			}
			bw.write("#"+t+" "+cnt+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
