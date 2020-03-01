package javaStudy.ch5_배열;

import java.util.Scanner;

public class MultiArrayEx4_단어맞추기 {
	/*
	 * 영단어를 보여주고 단어의 뜻을 맞추는 예제
	 * words[i][0]은 문제
	 * words[i][1]은 정답
	 * 
	 * words[i][0]을 화면에 뿌려줌
	 * 입력받은 답은 answer에 저장
	 * */
	public static void main(String[] args) {
		
		String[][] words = {
				{"chair","의자"}, //words[0][0] , words[0][1]
				{"computer","컴퓨터"}, //words[1][0] , words[1][1]
				{"integer","정수"} //words[2][0] , words[2][1]
		};
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<words.length;i++) {
			System.out.printf("Q%d. %s의 뜻은?", i+1, words[i][0]); //Q1. Q2. Q3 - > i+1
			
			String answer = sc.nextLine();
			
			if(answer.equals(words[i][1])) { //equals()로 배열 answer와 words[i][1]을 비교해서 정답인지 확인
				System.out.printf("정답!%n%n");
			} else {
				System.out.printf("오답! 정답은 %s %n%n",words[i][1]);
			}
		}//for of end 
	}//main of end
}
