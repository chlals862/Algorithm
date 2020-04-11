package baekjoon.문자열처리;

import java.util.Scanner;

/*알파벳 소문자로만 이루어진 단어 S가 주어진다.
각각의 알파벳에 대해서,
단어에 포함되어 있는 경우에는 처음 등장하는 위치를,
포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.*/

public class 알파벳찾기 {
	
	static int[] alpha = new int[26];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		//포함되지 않으면 -1이므로 s를 -1로 미리 초기화 시켜놓기
		for(int i=0;i<alpha.length;i++) {
			alpha[i] = -1;
		}
		//입력 && 로직
		for(int i=0;i<input.length();i++) {
			//input에서 문자 하나씩 ch에
			char ch = input.charAt(i);
			//System.out.print("ch = " + ch + " ");
			//System.out.println(ch-'a');
			if(alpha[ch - 'a'] == -1) {
				alpha[ch - 'a'] = i; //인덱스 뇌절금지,-'a'를 해주지않으면 arrayException
					//System.out.print("s[ch - 'a'] = " + s[ch - 'a'] + " ");
			}
		}//for
		
		//출력
		for(int i=0;i<alpha.length;i++) {
			System.out.print(alpha[i] + " ");
		}
	}
}
