package SW_EXPERT_ACADEMY.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 구구단1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for(int t=1;t<=T;t++) {
			boolean flag = false;
			int N = Integer.parseInt(br.readLine());
			for(int row=1;row<=9;row++) {
				for(int col=1;col<=9;col++) {
					if(row*col == N) {
						flag = true;
					}
				}
			}
			if(flag) {
				bw.write("#"+t+" Yes\n");
			}else {
				bw.write("#"+t+" No\n");
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}

