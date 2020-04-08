package baekjoon.시뮬레이션;

import java.util.Scanner;

/*
 * 알파벳 대소문자로 된 단어가 주어지면,
 *  이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 
 *  단, 대문자와 소문자를 구분하지 않는다.
 * 
 * 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 * */
public class 단어공부 {
	static int[] lowerAlpha = new int[26];
	//static int[] upperAlpha = new int[26];
	static int[] ascii = new int[256];
	//static int max = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String line = input.toUpperCase();//line이라는 변수는 입력한 문자를 소문자화한 것  ex)A입력시 line -> a
		
		//step1. 출현 알파벳에 맞는 아스키코드값 빈도수 카운트
		for(int i=0;i<line.length();i++) {
			
			char letter = line.charAt(i);//소문자화한 line의 길이만큼 반복문 돌면서 letter에 저장 ->저장된 값은 문자열

			int ascii1 = letter-'A';// 문자열에 - 'a'를 해주면 해당하는 인덱스값이 출력
									//ex)abcd입력하면 0123
			lowerAlpha[ascii1]++;//
		}
		//step2. 빈도수가 가장 큰 값은 얼만지 저장
		//lowerAlpha에 있는 값들 한번 싹 조사
			int temp = 0;
			for(int i=0;i<lowerAlpha.length;i++) {
				
				if(lowerAlpha[i] > temp) {
					temp = lowerAlpha[i];
				}
		}
		//step3. 가장 큰 빈도수를 가진 알파벳 찾기
			
			//빈도수가 2인게 여러개 일수도 있으니 예외처리를 위해 max변수 하나 잡음
			int max = 0;
			int idx = 0;
			for(int i=0;i<lowerAlpha.length;i++) {
				//temp는 빈도수가 가장 큰 값
				if(lowerAlpha[i] == temp) {//i번쨰의 크기가 temp와 같을 때 max카운트 증가 (예외처리하기 위해)
					max++;
					idx= i;
				}
				
			}
			if(max > 1) {
				System.out.println("?");
				return;
			}
			//알파벳을 나타내기 위해
			System.out.println((char)(idx+'A'));
	}
	
}
