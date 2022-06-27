package CodeUp.조건문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1171 {
	static int grade,ban,number;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		grade = Integer.parseInt(st.nextToken());
		ban = Integer.parseInt(st.nextToken());
		number = Integer.parseInt(st.nextToken());
		
		//grade는 조건필요 없고 무조건 뒤에 0
		//ban은 10미만이면 앞에 0붙이고
		//학번은 100이하면 0두개 10이하면 0 1개
		
		if(ban < 10) {
			if(number < 10) {
				System.out.println(grade+"0"+ban+"00"+number);
			}else if(number < 100) {
				System.out.println(grade+"0"+ban+"0"+number);
			}else System.out.println(grade+"0"+ban+number);
			
		}else if(ban >= 10) {
			if(number < 10) {
				System.out.println(grade+""+ban+"00"+number);
			}else if(number < 100) {
				System.out.println(grade+""+ban+"0"+number);
			}else System.out.println(grade+""+ban+number);
		}
	}
}
