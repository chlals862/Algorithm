package Do_it_알고리즘_코딩테스트;

public class 시간복잡도_판별원리3 {

	public static void main(String[] args) {
		int N = 100000;
		int cnt = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.println("연산 횟수 : " + cnt++);
			}
		}
	}
}
