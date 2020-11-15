package baekjoon.수학;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class 네번째점 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int[] x = new int[3];
		int[] y = new int[3];
		for(int row=0;row<3;row++) {
			st = new StringTokenizer(br.readLine());
			x[row] = Integer.parseInt(st.nextToken());
			y[row] = Integer.parseInt(st.nextToken());
		}
		if(x[0]==x[1])bw.write(x[2]+" ");
		else if(x[0]==x[2]) bw.write(x[1]+" ");
		else bw.write(x[0]+" ");
		
		if(y[0]==y[1])bw.write(y[2]+"");
		else if(y[0]==y[2]) bw.write(y[1]+"");
		else bw.write(y[0]+"");
		bw.flush();
		bw.close();
	}
}
