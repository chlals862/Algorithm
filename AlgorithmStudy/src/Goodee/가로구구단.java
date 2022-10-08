package Goodee;

import java.util.Scanner;

public class 가로구구단 {

	public static void main(String[] args) {
		for(int col=1;col<=9;col++) {
			for(int row=2;row<=9;row++) {
				System.out.print(row+" * " + col + " = " + row*col +" ");
			}
			System.out.println();
		}
	}
}
