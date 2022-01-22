package baekjoon.구현;

import java.io.IOException;
import java.util.Scanner;
/*
[input]
4 3
10 3
100 5
[output]
5
14
124
*/
public class 치킨쿠폰 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLong()) {
			Long coupon = sc.nextLong();
			Long needStamp = sc.nextLong();
			Long chicken = (long) 0; 
			Long stamp = (long) 0;
			
			while(coupon > 0) {
				chicken += coupon;
				stamp += coupon;
				coupon = (long) 0;
				coupon += stamp/needStamp;
				stamp %= needStamp;
				if(stamp / needStamp < 0 ) break;
			}
			
			System.out.println(chicken);
	//}
	}
}
}
//		while() {
//			int coupon = sc.nextInt();
//			int needStamp = sc.nextInt();
//			
//			
//			System.out.println(coupon);
//			System.out.println(needStamp);
			
			
			
//			chicken += coupon;
//			stamp += coupon;
//			coupon -= coupon;
//			coupon += stamp/needStamp;
//			System.out.println(coupon);
//			if(coupon == 0 && stamp/needStamp <0) {
//				System.out.println(chicken);
//				break;
//			}
		

		
		
		
		
		
//		while(true) {
//			int coupon = sc.nextInt();
//			int stamp = sc.nextInt();
//			coupon -= coupon; //ex) 쿠폰을 4만큼 빼고
//			System.out.println("coupon = " + coupon);
//
//			chicken += coupon;
//			System.out.println("chicken = " + chicken);
//			stamp += coupon; //스탬프를 쿠폰 쓴만큼 증가 시키고
//			System.out.println("stamp = " + stamp);
//			coupon += stamp/stamp; //스탬프 만큼 쿠폰수를 늘리고
//			
//			
//			//System.out.print("coupon = " + coupon + " stamp = " + stamp + " chicken = " + chicken+"\n");
//			
//			
//			if(coupon == 0 && stamp<stamp ) {
//				System.out.println(chicken+"----"); 
//				break;
//			}
//			
//		}
	


