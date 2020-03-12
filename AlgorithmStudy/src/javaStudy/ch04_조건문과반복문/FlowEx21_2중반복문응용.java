package javaStudy.ch04_조건문과반복문;

public class FlowEx21_2중반복문응용 {

	public static void main(String[] args) {
		for(int i = 1; i<= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				if(i==j) {
					System.out.printf("[%d,%d]", i,j);
				} else {
					System.out.printf("%5c",' ');
				}
			}
			System.out.println();
		}
	}
}
