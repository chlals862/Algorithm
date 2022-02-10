package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 집합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		Set<Integer> set = new HashSet<Integer>();
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int res = 0;
			switch(str) {
			case "add" :
				res = Integer.parseInt(st.nextToken());
				set.add(res);
				break;
			case "remove" :
				res = Integer.parseInt(st.nextToken());
				set.remove(res);
				break;
			case "check" :
				res = Integer.parseInt(st.nextToken());
				if(set.contains(res)) sb.append("1\n");
				else sb.append("0\n");
				break;
			case "toggle" :
				res = Integer.parseInt(st.nextToken());
				if(set.contains(res)) set.remove(res);
				else set.add(res);
				break;
			case "all" :
				for(int j=0;j<20;j++) set.add(j+1);
				break;
			case "empty" :
				set.clear();
				break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
