package baekjoon.수학;

import java.util.Scanner;
/*
 * 지구[E] -> 1~15
 * 태양[S] -> 1~28
 *  달[M] -> 1~19
 *  1년이 지날때마다 e,s,m 각각 1씩 추가
 * */
public class 날짜계산 {

	static int year = 0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		
		int e = 1;
		int s = 1;
		int m = 1;
		
		
		while(true) {
			year++; 
			if(e == E && s == S && m == M ) {
				break;
			}
			
			e++;
			s++;
			m++;
			
			if(e>15) {
				e=1;
			}
			if(s>28) {
				s=1;
			}
			if(m>19) {
				m=1;
			}
			
		}
		System.out.println(year);
	}
}
