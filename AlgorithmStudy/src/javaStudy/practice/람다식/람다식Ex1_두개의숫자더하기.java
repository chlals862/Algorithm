package javaStudy.practice.람다식;
	/* 람다식
	 * 장점
	 * 1.코드를 간결하게 만들 수 있음
	 * 2.코드가 간결하고 식에 개발자의 의도가 명확히 드러나므로 가독성이 향상
	 * 3.함수를 만드는 과정없이 한번에 처리할 수 있기에 코딩하는 시간이 줄어듦
	 * 4.병렬프로그래밍이 용이
	 * ----------------------------------------------
	 * 단점
	 * 1.람다를 사용하면서 만든느 무명함수는 재사용이 불가능
	 * 2.디버깅이 다소 까다로움
	 * 3.람다를 남발하면 코드가 지저분해질 수 있음(비슷한 함수를 계속 중복생성할 가능성이 높음)
	 * 4.재귀로 만들경우에는 다소 부적합한면이 있음
	 * */
interface Compare{
	public int compareTo(int a, int b);
}

public class 람다식Ex1_두개의숫자더하기 {

	//람다식 문법 (매개변수 목록)->{실행문}
	
	public static void exec(Compare com) {
		int k = 10;
		int m = 20;
		int value = com.compareTo(k, m);
		System.out.print("value = " + value);
	}
	public static void main(String[] args) {
		exec((i,j)-> {
			return i+j;
		});
	}
}
