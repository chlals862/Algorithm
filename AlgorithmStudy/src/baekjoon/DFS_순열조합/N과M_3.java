package baekjoon.DFS_순열조합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//중복 전부 허용 , 같은 수 여러번 가능
public class N과M_3 {
	static int N,M;
	static int[] choice;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		
		inputData();
		dfs(0);
		
	}
	private static void dfs(int count) throws IOException {
		if(count == M) {
			for(Integer answer : choice) {
				//System.out.print(answer + " ");
				bw.write(answer + " ");
			}
			bw.newLine();
			bw.flush();
			return;
		}
		
		for(int num = 1; num <= N; num++) {
			choice[count] = num;
			dfs(count+1);
		}
		
		
	}
	private static void inputData() throws IOException {
		//Scanner sc = new Scanner(System.in);
		
		//N = sc.nextInt();
		//M = sc.nextInt();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		choice = new int[M];
		//sc.close();
	}
}
