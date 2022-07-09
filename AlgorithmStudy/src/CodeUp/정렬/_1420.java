package CodeUp.정렬;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _1420 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] rank = new int[num];
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(int row=0;row<num;row++) {
			String name = sc.next();
			int score = sc.nextInt();
			
			map.put(score, name);
			rank[row] = score;
		}
		Arrays.sort(rank);
		
		System.out.println(map.get(rank[num-3]));
	}
}
