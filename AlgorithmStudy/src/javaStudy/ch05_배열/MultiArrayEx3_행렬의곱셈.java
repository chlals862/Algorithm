package javaStudy.ch05_배열;

public class MultiArrayEx3_행렬의곱셈 {
	/*
	 * 행렬의 곱셈이 가능하려면 m1의 열(3)과 m2의 행(3)길이가 같아야 함
	 * m1xm2의 결과 값인 m3은 2행 2열 (m1의 행)+ (m2의 열)임
	 * */
	public static void main(String[] args) {
		
		int[][] m1 = { //2행 3열
				{1,2,3},
				{4,5,6}
		};
		int[][] m2 = { //3행 2열
				{1,2},
				{3,4},
				{5,6}	
		};
		/* m1과 m2의 길이가 달라져도 행렬 m3가 계산될 수 있도록, 배열 m3의 크기와 for문의 조건식이 동적으로 계산되게 함
		 * 
		 * */
		final int ROW = m1.length; // m1의 행 길이 -> 2
		final int COL = m2[0].length; //m2의 열 길이 -> 2
		final int M2_ROW = m2.length; //m2의 행 길이 -> 3
		
		int m3[][] = new int[ROW][COL]; //m3의 행은 m1의 행길이 m3의 열은 m2의 열 길이와 같음
		
		//행렬곱 m1*m2의 결과를 m3에 저장
		/*
		 * m3[i][j] => m1[i][0] * m2[0][j]
		 *          +  m1[i][1] * m2[1][j]
		 *          +  m1[i][2] * m2[2][j];  
		 *    이 문장을 
		 * for(int k=0;k<M2_ROW;k++) 
					m3[i][j] += m1[i][k] * m2[k][j];
		 *    for문을 하나 더 추가하여 간단히 쓸수 있음
		 * */
		for(int i=0;i<ROW;i++)//ROW = 2   i = 0 1 
			for(int j=0;j<COL;j++)//COL = 2 j = 0 1
				for(int k=0;k<M2_ROW;k++) //M2_ROW = 3 k= 0 1 2 
					m3[i][j] += m1[i][k] * m2[k][j];
		
		//m3 출력
		for(int i=0; i<ROW; i++) {
			for(int j=0; j<COL; j++) {
				System.out.printf("%5d",m3[i][j]);
			}//for of end j
			System.out.println();
		}//for of end i 
	}//main of end
}
