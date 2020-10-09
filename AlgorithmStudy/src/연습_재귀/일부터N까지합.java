package 연습_재귀;

public class 일부터N까지합 {

	public static void main(String[] args) {
		System.out.println("" + function(5)); // 5까지의 합은?
	}

	// 5 -> 5+4+3+2+1
	// 4 -> 4+3+2+1
	private static int function(int num) {
		if (num == 1) {
			return 1;
		} else {
			return num = num + function(num - 1);
		}
	}
}