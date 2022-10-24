package SW_EXPERT_ACADEMY.D3;

import java.util.Scanner;

public class 알파벳공부 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for(int T=0;T<t;T++) {
			char[] ch = new char[26];
			int cnt = 0;
			int correct = 0;
			for(char i='a'; i<='z'; i++) {
				ch[cnt] = i;
				cnt++;
			}
			
			char[] str = sc.nextLine().toCharArray();
			for(int row=0;row<str.length;row++) {
				if(ch[row] == str[row]) {
					correct++;
				}else {
					break;
				}
			}
			System.out.println("#"+(T+1)+" "+correct);
		}
	}
}
