package javaCrystallization.ch3_연산자;

public class OperatorEx32_조건연산자 {

	public static void main(String[] args) {
		int x = 10, y = -5, z = 0;
		int absX, absY, absZ;
		char signX, signY, signZ;
		
		//x의 값이 음수이면 양수로 만듦
		absX = x >= 0 ? x : -x; //x가 0보다 크거나 같으면 x , false면 -x  -> true이므로 +10
		absY = y >= 0 ? y : -y; //y가 0보다 크거나 같으면 y , false면 -y  -> false이므로 -5
		absZ = z >=0 ? z : -z; //z가 0보다 크거나 같으면 z , false면 -z   -> true이므로 0
		
		//조건연산자 중첩
		signX = x > 0 ? '+' : ( x==0 ? ' ' : '-'); //x가 0보다 크면 '+' : (x==0이면 ' ' false면 -)
		signY = y > 0 ? '+' : ( y==0 ? ' ' : '-');
		signZ = z > 0 ? '+' : ( z==0 ? ' ' : '-');
		
		System.out.printf("x = %c%d%n", signX, absX);
		System.out.printf("y = %c%d%n", signY, absY);
		System.out.printf("z = %c%d%n", signZ, absZ);
	}
}
