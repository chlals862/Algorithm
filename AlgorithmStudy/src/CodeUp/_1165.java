package CodeUp;

import java.util.Scanner;

public class _1165 {

	public static void main(String[] args) {
		//1번
		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt();
		int score = sc.nextInt();
		/*
		//1번 방식
		while(time<90) {
			score++;
			time+=5;
		}
		System.out.println(score);
		*/
		if(time < 90) {
			score++;
			score += (89-time)/5;
		}
		System.out.println(score);
	}
}
