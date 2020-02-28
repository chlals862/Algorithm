package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TestRun {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//Input Test
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		printData();
		
	}
	private static void printData() throws IOException {
		bw.flush();
		bw.close();
	}
	private static void setData() throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int testcase=1;testcase<=T;testcase++) {
			bw.write(testcase+"\n");
		}
		
	}
}
