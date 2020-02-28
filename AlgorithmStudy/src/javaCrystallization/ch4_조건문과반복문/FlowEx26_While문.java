package javaCrystallization.ch4_조건문과반복문;

public class FlowEx26_While문 {

	public static void main(String[] args) {
		int sum = 0;
		int i = 0;
		
		while((sum += ++i) <= 100) {
			System.out.printf("%d - %d%n", i, sum);
		}
	}
}
