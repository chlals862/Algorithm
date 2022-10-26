package SW_EXPERT_ACADEMY.D3;
/*
3
7
15 15 15 15 15 15 15
10
1 1 1 1 1 1 1 1 1 100
7
2 7 1 8 2 8 4
 * */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 소득불균형 {
	static int T,N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		setData();
	}
	private static void setData() throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int sum = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<arr.length;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			int avg = sum/arr.length;
			int count = 0;
			
			for(int i=0;i<arr.length;i++) {
				if(arr[i] <= avg) {
					count++;
				}
			}
			bw.write("#"+t+" "+count+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
