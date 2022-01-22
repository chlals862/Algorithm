package baekjoon.구현;

import java.util.Scanner;

public class 윷놀이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		for(int i=0;i<3;i++) {
			//int a = sc.nextInt();
			//int b = sc.nextInt();
			int count = 0;
			for(int j=0;j<4;j++) {
				if(sc.nextInt() == 0) {
					count++;
				}
			}
			switch(count) {
			case 0 : System.out.println("E");
				break;
			case 1 : System.out.println("A");
				break;
			case 2 : System.out.println("B");
				break;
			case 3 : System.out.println("C");
				break;
			case 4 : System.out.println("D");
				break;
			}
		}

	}

}
