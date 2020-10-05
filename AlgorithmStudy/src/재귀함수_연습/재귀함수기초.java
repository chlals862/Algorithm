package 재귀함수_연습;

public class 재귀함수기초 {

	public static void main(String[] args) {
		recursiveFunction(1);
	}

	private static void recursiveFunction(int i) {
		//100번째 호출을 헀을 때 종료
		if(i == 100) return;
		System.out.println(i + "번째 재귀 함수에서 " + (i+1)+ "번째 재귀함수를 호출.");
		recursiveFunction(i+1);
		System.out.println(i + "번째 재귀 함수를 종료.");
		
	}
}
