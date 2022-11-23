package SW_EXPERT_ACADEMY.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 적고지우기 {
/*
3
121
0123456789
555555
 * */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			StringBuilder sb = new StringBuilder();
			String str = br.readLine();
			int cnt = 0;
			int[] num = new int[str.length()];
			
			for(int row=0;row<num.length;row++) {
				num[row] = str.codePointAt(row);
			}
			
			for(int row=0;row<num.length-1;row++) {
				for(int col=row+1;col<num.length;col++) {
					if(num[row] == num[col]) {
						cnt++;
						break;
					}
				}
			}
			sb.append("#"+i+" ");
			if(cnt > 0) {
				sb.append(str.length()-1-cnt);
			}else {
				sb.append(str.length());
			}
			bw.write(sb+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
