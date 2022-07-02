package CodeUp.기초;

import java.util.Scanner;

public class _1116 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		System.out.println(num1+"+"+num2+"="+(int)(num1+num2));
		System.out.println(num1+"-"+num2+"="+(int)(num1-num2));
		System.out.println(num1+"*"+num2+"="+(int)(num1*num2));
		System.out.println(num1+"/"+num2+"="+(int)(num1/num2));
	}
}
