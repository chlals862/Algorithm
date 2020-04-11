package baekjoon.문자열처리;

import java.util.Scanner;

//문장을 읽은 뒤, 줄의 첫 글자를 대문자로 바꾸는 프로그램을 작성하시오.

//입력
/*첫째 줄에 줄의 수 N이 주어진다. 다음 N개의 줄에는 문장이 주어진다.
각 문장에 들어있는 글자의 수는 30을 넘지 않는다.
모든 줄의 첫 번째 글자는 알파벳*/

//출력
//각 줄의 첫글자를 대문자로 바꾼뒤 출력
public class 첫글자를대문자로 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		String[] input = new String[num];
		//개행문자 입력 
		sc.nextLine();//이거 없으면 String out of range error!
		
		//입력
		for(int i=0;i<num;i++) {
			input[i] = sc.nextLine();
		}
		//로직 && 출력 -> 줄의 첫 글자를 대문자로
		for(int i=0;i<num;i++) {
			System.out.print(input[i].toUpperCase().charAt(0)); //첫번째만 대문자화
			
			for(int j=1;j<input[i].length();j++) { //나머지 표출
				System.out.print(input[i].charAt(j));
			}
			System.out.println();
		}
	}//main
}
