package SW_EXPERT_ACADEMY.D2;

import java.util.Scanner;

public class 간단한압축풀기 {
	static int T,caseT;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			caseT = sc.nextInt();
			for(int ct=1;ct<=caseT;ct++) {
				String str = sc.next();
				int count = sc.nextInt();
				for(int row=1;row<=count;row++) {
					sb.append(str);
				}
			}
			System.out.println();
		}
		
	}
}
