package javaCrystallization.ch4_조건문과반복문;

public class FlowEx20_2중반복문 {

	public static void main(String[] args) {
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				System.out.printf("[%d,%d]",i,j);
			}
			System.out.println();
		}
	}
}
