package baekjoon.수학;

import java.math.BigInteger;
import java.util.Scanner;
//북마크참고
public class 최대공약수 {
	
	static BigInteger BigRing;
	static BigInteger num[];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int inputNum = sc.nextInt();
		BigRing = new BigInteger(sc.next());
		
		BigInteger num[] = new BigInteger[inputNum-1];
		
		for(int i=0; i<inputNum-1; i++) {
			num[i] = new BigInteger(sc.next());
			//System.out.println(num[i]);
		}
		
		
		for(BigInteger otherRing : num) {
								//BigRing = 12,otherRing = 3 8 4 
								//gcd 최대공약수 구하기 ->       3 4 4
			BigInteger ring = BigRing.gcd(otherRing);
			//System.out.println("gcd 후  ring = " + ring);
			//System.out.println("otherRing = " + otherRing);
				//ring = 3 4 4  otherRing = 3 8 4
			
			            //12나누기 3 4 4  -> 4 3 3      3나누기3 -> 1, 8나누기4 -> 2, 4나누기4 -> 1      	       
			System.out.println(BigRing.divide(ring) + "/" + otherRing.divide(ring));
		}
		
		
		
		}
	
}
	

