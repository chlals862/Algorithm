package javaStudy.ch05_배열;

import java.util.Scanner;

public class MultiArrayEx1_배의위치알아내기 {
	/*
	 * 둘이 마주 앉아 다양한 크기의 배를 상대방이 알지 못하게 배치한 다음, 
	 * 번갈아가며 좌표를 불러서 상대방의 배의 위치를 알아내는 게임을 간단히 한 예쩨
	 * 2차원 배열 char배열 board는 입력한 좌표를 표시하기 위한 것
	 * 2차원 배열 byte배열 shipBoard에는 상대방의 배의 위치를 저장
	 * 0은 바다 
	 * 1은 배가 있음
	 * */
	public static void main(String[] args) {
		
		final int SIZE = 10; //상수
		int x = 0, y = 0;
		
		char[][] board = new char[SIZE][SIZE]; //배열 board는 좌표를 쉽게 입력받기 위한 행번호와 열번호가 필요함
		byte[][] shipBoard = {                 //그래서 배열 board가 배열 shipBoard보다 행과 열의 길이가 1씩 큰 것임
			//   1 2 3 4 5 6 7 8 9
				{0,0,0,0,0,0,0,0,0}, //1
				{1,1,1,1,0,0,1,0,0}, //2
				{0,0,0,0,0,0,1,0,0}, //3
				{0,0,0,0,0,0,1,0,0}, //4
				{0,0,0,0,0,0,0,0,0}, //5
				{1,1,0,1,0,0,0,0,0}, //6
				{0,0,0,1,0,0,0,0,0}, //7
				{0,0,0,1,0,0,0,0,0}, //8
				{0,0,0,0,0,1,1,1,0}, //9
		};
		//1행에 행번호를, 1열에 열번호를 저장
		for(int i=1;i<SIZE;i++) 
			board[0][i] = board[i][0] = (char)(i+'0'); //(char)(1+'0') -> '1'
													   //(char)(2+'0') -> '2'
		/*
		 * board는 char배열이므로 숫자를 문자로 변환하여 저장해야함
		 * 그래서 변수 i에 문자 '0'을 더함
		 * 숫자 1에 문자'0'을 더하면 문자 '1'이 됨
		 * 그 다음엔 무한반복문으로 좌표를 반복해서 입력받음
		 * 입력받은 좌표 x,y에 저장된 값이 1이면, board[x][y]에 'O'를 저장하고
		 * 1이 아니면 'X'를 저장함
		 * 배열 board와 shipBoard간에는 좌표가 가로,세로로 각각 1씩 차이가 남
		 * */
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.printf("좌표를 입력하세요. (종료는 00)>");
				String input = sc.nextLine(); //화면의 입력받은 내용을 input에 저장하기
				
				if(input.length()==2) { //두 글자를 입력한 경우
					x = input.charAt(0) - '0'; //문자를 숫자로 변환
					y = input.charAt(1) - '0'; //입력을 2개를 해야하니 charAt(0)과 charAt(1)을 숫자로 변환
					
					if( x==0 && y==0)//x와 y가 모두 0인 경우 종료
						break;
				}//if of end
				
				if(input.length() !=2 || x<=0 || x>=SIZE || y<=0 || y>=SIZE) { //입력받은 길이가 2가 아니거나 x가 0보다 작거나 같을떄, 입력한 행의 x가 SIZE보다 크거나 같을때(10) ...y도 마찬가지
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
					continue; //다시 위의 반복문인 while문으로 되돌아감
				}
				
				// shipBoard[x-1][y-1]의 값이 1이면(입력받은 좌표 x,y에 저장된 값이 1이면), 'O'을 board[x][y]에 저장
				// x-1,y-1을 해주는 이유는 shipBoard와 board가 가로,세로 1씩 차이나서임
				board[x][y] = shipBoard[x-1][y-1] == 1 ? 'O' : 'X'; //삼항 연산식  조건부가 true일때 'O' , false이면 'X'
				//index는 0,0부터 시작하므로 x와 y에 -1씩 해줘야함
				
				//배열 board의 내용을 화면에 출력
				for(int i=0;i<SIZE;i++)
					//2차원 char배열의 각 요소는 1차원 배열이므로 아래와 같이 간단히 출력이 가능
					//println메서드로 1차원 char배열의 참조변수를 출력하면 배열의 모든 요소를 한 줄로 출력함 , char배열인 경우만 가능
					System.out.println(board[i]); //board[i]는 1차원 배열
					System.out.println();
					
					/*
					 * for(int i=0;i<SIZE;i++) {
					 * System.out.println(board[i]); 이 문장은 char배열일 경우만 가능하고 원래는
					 * 
					 * for(int i=0;i<SIZE;i++) {
					 *  for(int j=0;j<SIZE;j++) {
					 *   	System.out.print(board[i][j]);
					 *    System.out.println();
					 *     }과 동일함
					 *   }
					 * }
					 * 
					 * */
				
			}//while of end
		}//main of end
	}
