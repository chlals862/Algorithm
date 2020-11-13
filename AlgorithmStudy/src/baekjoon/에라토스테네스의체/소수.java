package baekjoon.에라토스테네스의체;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 소수 {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int minv = 10001;
		int count = 0;
		int sum = 0;
		int min = Integer.parseInt(br.readLine());
		int max = Integer.parseInt(br.readLine());
		for(int row=min; row<=max;row++) {
			for(int col=2;col<row;col++) {
				if(row%col == 0) count++;
			}
			if(count == 0 && row != 1) {
				sum+=row;
				if(minv>row) minv=row;
			}
			count = 0;
		}
		if(minv == 10001) {
			bw.write(-1+"");
		}else {
			bw.write(sum+"\n");
			bw.write(minv+"");
		}
		bw.flush();
		bw.close();
	}
}
