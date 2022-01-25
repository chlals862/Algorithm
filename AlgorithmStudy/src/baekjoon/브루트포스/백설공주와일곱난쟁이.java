package baekjoon.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백설공주와일곱난쟁이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int nonan1 = 0; int nonan2 = 0; //난쟁이 아닌것들
		int nan[] = new int[9];
		int sum = 0;
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			nan[i] = Integer.parseInt(st.nextToken());
			sum += nan[i];
		}
		//난쟁이 아닌것들 찾기
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(sum - nan[i] - nan[j] == 100) {
					nonan1 = i; 
					nonan2 = j;
				//	System.out.println(nonan1);
				//	System.out.println(nonan2);
				}
			}
		}
		//배열 전체를 탐색후 , 난쟁이가 아닌 2명의 인덱스값을 갖지 않는 배열값 구하기
		for(int i=0;i<9;i++) {
			if(nonan1 != i && nonan2 != i)
				bw.write(nan[i]+"\n");
		}
		bw.flush();
		bw.close();
	}
}
