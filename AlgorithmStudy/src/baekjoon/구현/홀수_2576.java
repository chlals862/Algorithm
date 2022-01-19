package baekjoon.구현;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 홀수_2576 {
	static int cnt,sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<7;i++) {
			int input = sc.nextInt();
			if(input % 2 == 1) {
				list.add(input);
				sum += input;
			}
		}
		Collections.sort(list);
		if(list.isEmpty()) System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(list.get(0));
		}
		
		//ArrayList<Integer> list = new ArrayList<Integer>();
		
//		for(int i=1;i<=7;i++) {
//			list.add(sc.nextInt());
//		}
//		
//		//System.out.println(list.get(1));
//		for(int i=0;i<=list.size()-1;i++) {
//			System.out.println(list.get(i));
//			if(list.get(i).intValue() % 2 ==0) {
//				System.out.println("난 짝수");
//				list.remove(i).intValue();
//			}
//		}
//		System.out.println(list);
//		for(int i=0;i<list.size();i++) {
//			sum += list.get(i);
//		}
//		System.out.println(sum);
		//System.out.println(list);
		
		
//		Iterator it = list.iterator();
//		while(it.hasNext()) {
//			int a = (Integer)it.next();
//			if(a % 2 == 0) it.remove();
//		}
//		System.out.println(list);
		//System.out.println(list);
		//System.out.println(list.size());
		//int cnt = 0;
		//for(int i=0;i<=list.size()-1;i++) {
		
			//if(list.get(i).valueOf(i%2==0))) {
			//	System.out.println(list.get(i)+"ss");
				//list.remove(i);
			}
		
//		if(list.size() == 7) {
//			System.out.println(-1); //홀수가 없다면 -1
//		}else {
//			for(int i=0;i<=list.size()-1;i++) {
//				sum += list.get(i);
//			}
//			Collections.sort(list);
//			System.out.println("sum = " + sum);
//		}
		//System.out.println(list);
	//}

}
