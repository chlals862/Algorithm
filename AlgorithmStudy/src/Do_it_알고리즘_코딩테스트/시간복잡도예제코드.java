package Do_it_알고리즘_코딩테스트;

public class 시간복잡도예제코드 {

	public static void main(String[] args) {
		int findNumber = (int)(Math.random() * 100);
		for(int i=0;i<100;i++) {
			if(i == findNumber) {
				System.out.println(i);
				break;
			}
		}

	}

}
