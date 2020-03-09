package SW_EXPERT_ACADEMY.D1;

import java.util.Scanner;

public class 아주간단한계산기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        int first = sc.nextInt();
        int second = sc.nextInt();
         
        if(first >= 1 && first <= 9) {
            if(second >= 1 && second <= 9) {
             
                System.out.println(first+second);
                System.out.println(first-second);
                System.out.println(first*second);
                int n = first/second;
                System.out.println(Math.round(n));
                 
            }
        }
	}
}
