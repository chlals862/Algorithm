package baekjoon.수학;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 행복 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=1;i<=N;i++) {
			int a = sc.nextInt();
			list.add(a);
		}
		list.sort(Collections.reverseOrder());
		System.out.println(list.get(0)-list.get(list.size()-1));
	}

}
