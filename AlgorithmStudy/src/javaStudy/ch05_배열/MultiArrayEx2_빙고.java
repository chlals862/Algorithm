package javaStudy.ch05_배열;

import java.util.Scanner;

public class MultiArrayEx2_빙고 {
	/*
	 * 5x5크기의 빙고판에 1~25숫자 넣고 빙고판의 숫자와 입력한 숫자가 같으면 0처리
	 * */
	public static void main(String[] args) {
		
		final int SIZE = 5;//5X5빙고판
		int x = 0, y = 0, num = 0;
		
		int[][] bingo = new int[SIZE][SIZE]; //5행 5열의 빙고판
		Scanner sc = new Scanner(System.in);
		
		//배열의 모든 요소를 1부터 SIZE*SIZE까지의 숫자로 초기화
		for(int i=0;i<SIZE;i++) { 
			for(int j=0;j<SIZE;j++) { 
				bingo[i][j] = i*SIZE + j+1;//1부터~25까지 랜덤한 숫자를 섞기위해 +1 
				
			}
		}
				//배열에 저장된 값을 뒤섞기 -> shuffle
				for(int i=0; i<SIZE; i++) {
					for(int j=0; j<SIZE; j++) {
						x = (int)(Math.random() * SIZE);
						y = (int)(Math.random() * SIZE);
				
				//bingo[i][j]와 임의로 선택된 값 bingo[x][y]을 바꿈
				int tmp = bingo[i][j];
				bingo[i][j] = bingo[x][y];
				bingo[x][y] = tmp;
			}//for of end j
		}//for of end i
			
				do {
					for(int i=0;i<SIZE;i++) {
						for(int j=0;j<SIZE;j++) 
							System.out.printf("%5d", bingo[i][j]);
						System.out.println();
						}//for of end i
					System.out.println();
					
					System.out.printf("1~%d의 숫자를 입력하세요. (종료:0)>",SIZE*SIZE);
					String tmp = sc.nextLine();
					num = Integer.parseInt(tmp);
				
				//입력받은 숫자와 같은 숫자가 저장된 요소를 찾아서 0을 저장
					outer :
					for(int i=0; i<SIZE;i++) {
						for(int j=0; j<SIZE;j++) {
							if(bingo[i][j] ==num) {
								bingo[i][j] = 0; //일치하는 숫자를 찾으면 0으로 변경
								break outer; //2중 반복문 벗어남
							}//if of end
						}//for of end j
					}//for of end i
				} while(num != 0);
	}
}
