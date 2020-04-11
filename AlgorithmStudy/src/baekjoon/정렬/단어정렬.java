package baekjoon.정렬;
/*알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
1. 길이가 짧은 것부터
2. 길이가 같으면 사전 순으로*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 단어정렬 {

	public static void main(String[] args) throws IOException {

		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int input = sc.nextInt();
		//문자열을 숫자로 반환
		int s = Integer.parseInt(br.readLine());
		/*
		 * ★★★★★compareTo★★★★★ 2개의 두 문자열을 비교하고 int형 값을 반환 A.compareTo(B) A == B -> 0
		 * return A > B -> 양수 return A < B -> 음수 return 맨 첫자리부터 차례대로 비교하는 특성 ex)A =
		 * feff0041 || B = feff0042 A.compareTo(B) -> -1 ->A가 B보다 작음
		 */
		// 문자들을 담을 list
		// List<String> list = new ArrayList<String>();
		// String[] arr = new String[];
		// String[] list = new String[input];

		// String[] temp = new String[input];
		List<String> list = new ArrayList<String>(s);
		
		// 입력 && 로직
		for (int i = 0; i <s; i++) {
			String in = br.readLine();
			
			// contains() -> 대상 문자열에 특정 문자열이 포함되어 있는지 확인 -> 대소문자 구분
			// list에 입력한 s가 포함되지 않으면 list에 s를넣음 -> 중복제거
			if (!list.contains(in)) {
				list.add(in);
			}
			//System.out.println("list = " + list);
		}//for
		
		Comparator<String> compare = new Comparator<String>() {
			public int compare(String a, String b) {
				if (a.length() > b.length()) {
					return 1;

				} else if (a.length() == b.length()) {
					return a.compareTo(b);
				}
				return -1;
			}
		};//compare
		/*
		 * for (int i = 0; i < list.size(); i++) { System.out.print("정렬 전 = " +
		 * list.get(i).length()); }
		 */
		Collections.sort(list, compare);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			//System.out.print("정렬 후 = " + list.get(i).length());
		}
	}// main
}
//--------------------------------------------------------------------------

// step1. 각 문자열의 길이가 가장 적은것 부터
//		for(int i=0;i<list.length;i++) {
//			for(int j=i+1;j<list.length;j++) {
//				if(list[i].length() > list[j].length()) {
//					
//					temp[i] = list[i];
//					list[i] = list[j];
//					list[j] = temp[i];
//					//System.out.println("temp[i] = " + temp[i]);
//					//System.out.println("list[i] = " + list[i]);
//					//System.out.println("list[j] = " + list[j]);
//				} else if(list[i].length() == list[j].length()) {
//					//step2. 문자열의 길이가 같으면 사전순으로 -> 정렬
//					Arrays.sort(list);
//					System.out.println(list[i]);
//				}
//			}
//		}

// 출
