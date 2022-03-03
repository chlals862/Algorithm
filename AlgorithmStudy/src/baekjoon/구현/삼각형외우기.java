package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 삼각형외우기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		if(A == 60 && B == 60 && C == 60) bw.write("Equilateral\n");
		else if(A+B+C == 180 && A == B || A == C || B == C) bw.write("Isosceles\n");
		else if(A+B+C == 180 && A != B && A != C && B != C) bw.write("Scalene\n");
		else bw.write("Error\n");
		bw.flush();
		bw.close();
	}

}
