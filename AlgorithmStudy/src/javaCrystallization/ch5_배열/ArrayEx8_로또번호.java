package javaCrystallization.ch5_배열;

public class ArrayEx8_로또번호 {
	/*
	 * 로또번호 추첨
	 * 1~45의 랜덤한 숫자 6개 뽑기
	 * */
	public static void main(String[] args) {
		
		int ball[] = new int[45];
		
		for(int i=0; i<ball.length;i++) 
			ball[i] = i+1; //ball[0]에 1을 저장
		
			int temp = 0; //두 값을 바꾸는데 사용할 임시변수
			int j = 0; // 임의의 값을 얻어서 저장할 변수
			
			/*
			 * 배열의 i번째 요소와 임의의 요소에 저장된 값을 서로 바꿔서 값을 섞는다.
			 * 0번쨰 부터 5번째 요소까지 모두 6개만 바꾼다.
			 * */
			for(int i=0; i<6;i++) {
				j = (int)(Math.random() * 45); //0~44범위의 임의의 값을 얻음
				//ball[i]와 ball[j]의 값을 서로 바꿈
				temp = ball[i];
				ball[i] = ball[j];
				ball[j] = temp;
			}//for of end
			
			//배열 ball의 앞에서 부터 6개 출력
			for(int i=0; i<6;i++) {
				System.out.printf("ball[%d]=%d%n", i, ball[i]);
			}
	}
}
