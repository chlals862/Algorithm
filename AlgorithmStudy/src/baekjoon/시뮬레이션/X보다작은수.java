package baekjoon.시뮬레이션;
//정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 

//이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
/*
 * 입력 10 5   10 -> N개의 정수, 5 -> 5보다 작은수
 * 1 10 4 9 2 3 8 5 7 6 
 ---------------------------------------------
 * 출력 
 * 1 4 2 3
 * */

import java.util.Scanner;

public class X보다작은수 {
	static int[] numList;
	//static int checkIdx = 0;
	//static List list;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int inputNum = sc.nextInt(); // N개의정수
		int X = sc.nextInt(); // X값

		int[] numList = new int[inputNum];
		for (int i = 0; i < inputNum; i++) {
			numList[i] = sc.nextInt();

			if (numList[i] < X) {
				System.out.print(numList[i] + " ");
			}

		}
		/*
		 * List list = new ArrayList();
		 * 
		 * if(numList[checkIdx] < X) { list.add(numList[checkIdx]); checkIdx++; } else
		 * if(numList[checkIdx] > X) { checkIdx++; count++; } // }
		 * 
		 * System.out.print(list); } System.out.println(count); }
		 */
	}
}
