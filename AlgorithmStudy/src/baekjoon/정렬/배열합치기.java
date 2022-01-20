package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 배열합치기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//int N = sc.nextInt();
		//int M = sc.nextInt();
		//HashSet<Integer> list = new HashSet<Integer>();
		st= new StringTokenizer(br.readLine());
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<N;i++) result.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) result.add(Integer.parseInt(st.nextToken()));
		
		
		Collections.sort(result);
		for(int i=0;i<result.size();i++) {
			bw.write(result.get(i)+" ");
		}
		bw.flush();
		bw.close();
		//String[] C =  list.toArray(new String[list.size()]);
		//System.out.println(Arrays.toString(C).);
		//for(int i=0;i<C.length;i++) 
		//for(int i=0;i<N;i++) C[i] = sc.nextInt();
		//for(int i=N;i<N+M;i++) C[i] = sc.nextInt();
		
		//int first = 0; int last = C.length;
			//while(last <= first) {
			//	if(C[first] ==)
			//}		
		//for(int i=0;i<N+M;i++) System.out.println(C[i]);
		
	}

}
