package SW_EXPERT_ACADEMY.D1;

import java.util.Scanner;

public class 홀수만더하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        int count = sc.nextInt();
        int sum = 0;
         
        for(int i=0; i<count; i++) {
            sum = 0;
            for(int j=0; j<10; j++) {
                int num = sc.nextInt();
                if(num >= 0 && num <= 10000) {
                    if(num%2 != 0) 
                        sum += num;
                }
            }   
                System.out.println("#" + (i+1) + " " + sum);
        }
         
    }
}
