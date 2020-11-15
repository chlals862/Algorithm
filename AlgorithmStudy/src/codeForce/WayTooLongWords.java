package codeForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class WayTooLongWords {
	static int N;
	static String[] str;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int k=0;k<N;k++) {
			str = br.readLine().split("");
			if(str.length <= 10) {
				for(String result : str)bw.write(result+"");
				bw.write("\n");
			}else if(str.length > 10) {
				int length = str.length;
				length-=2;
				bw.write(str[0]+""+length+""+str[str.length-1]+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
