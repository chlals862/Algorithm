package SW_EXPERT_ACADEMY.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 조별과제 {
	//이게 어째서 D3?
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			int N = Integer.parseInt(br.readLine());
			
			bw.write("#"+i+" "+ N/3+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
