package javaCrystallization.ch5_배열;

public class ArrayEx18_2차원배열 {
	/*
	 * 2차원 배열 score의 모든 요소의 합을 구하고 출력
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		
		int[][] score = {//4행3열인 2차원 배열 생성 및 값 선언
							{ 100, 100, 100 }
						   ,{  20,  20,  20 }
						   ,{  30,  30,	 30 }
						   ,{  40,  40,	 40 }		
						};
		int sum = 0; 
		
		for(int i=0; i<score.length;i++) { //열
			for(int j=0; j<score[i].length;j++) { //행
				System.out.printf("score[%d][%d]=%d%n", i, j, score[i][j]);
			}
		}
		//향상된 for문은 배열의 각 요소에 저장된 값들을 순차적으로는 읽어올 수는 있지만, 저장된 값은 변경 불가능
		for (int[] tmp : score) { // 2차원배열 score의 각 요소는 1차원 배열이므로 for문을 하나 추가해야함
			for(int i : tmp) { //2차원 배열 score의 각 요소는 1차원 배열이므로 tmp대신 score가 들어가면 에러  , tmp는 1차원 배열을 가리키는 참조변수 
				sum += i;
			}
		}
		
		System.out.println("sum = " + sum);
		
		
	}
}
