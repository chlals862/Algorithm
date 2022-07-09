package CodeUp.조건문;

import java.util.Scanner;

public class _1170 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int grade = sc.nextInt();
		int ban = sc.nextInt();
		int num = sc.nextInt();
		
		if(num < 10) {
			System.out.println(grade+""+ban+""+"0"+num);
		}else {
			System.out.println(grade+""+ban+""+num);
		}
	}
}
