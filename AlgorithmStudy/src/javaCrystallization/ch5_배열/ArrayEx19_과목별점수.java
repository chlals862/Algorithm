package javaCrystallization.ch5_배열;

public class ArrayEx19_과목별점수 {

	public static void main(String[] args) {
		
		int[][] score = {
				{100,100,100}
			   ,{20,20,20}
			   ,{30,30,30}
			   ,{40,40,40}
			   ,{50,50,50}
		};
		//과목별 총점
		int korTotal = 0, engTotal = 0, mathTotal = 0;
		
		System.out.println(" 번호  국어    영어    수학    총점    평균  ");
		System.out.println("=============================");
		
		for(int i=0;i<score.length;i++) {
			int sum =0; //개인별 총점
			float avg = 0.0f; //개인별 평균
			
			korTotal += score[i][0]; //i행 0열 
			engTotal += score[i][1]; //i행 1열
			mathTotal += score[i][2]; //i행 2열
			System.out.printf("%3d", i+1); // i+1 ->번호 1부터시작
			
			for(int j=0;j<score[i].length;j++) {
				sum += score[i][j];
				System.out.printf("%5d",score[i][j]);
			}//for of end j
			avg = sum /(float)score[i].length; //평균계산 행의 숫자만큼 sum을 나눔
			System.out.printf("%5d %5.1f%n", sum,avg);
		}//for of end i
		System.out.println("=============================");
		System.out.printf("총점:%5d %4d %4d%n",korTotal,engTotal,mathTotal);
		
	}
}
