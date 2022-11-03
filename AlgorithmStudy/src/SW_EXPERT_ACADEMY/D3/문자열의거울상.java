package SW_EXPERT_ACADEMY.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 문자열의거울상 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			StringBuilder sb = new StringBuilder();
			String str = br.readLine();
			for(int j=0;j<str.length();j++) {
				switch(str.charAt(j)) {
				case 'b' :
					sb.append("d");
					break;
				case 'd' :
					sb.append("b");
					break;
				case 'p' :
					sb.append("q");
					break;
				case 'q' :
					sb.append("p");
					break;
				}
			}
			bw.write("#" + i + " " +sb.reverse()+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
		
	}
}
