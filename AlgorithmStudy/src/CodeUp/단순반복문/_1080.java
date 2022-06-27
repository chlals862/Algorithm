package CodeUp.단순반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1080 {
	static int num,sum,count;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		num = Integer.parseInt(br.readLine());
		
		count = 0;
		while(true) {
			count++;
			sum += count;
			if(sum >= num) break;
		}
		bw.write(count+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
