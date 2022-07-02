package CodeUp.배열;

import java.util.Arrays;
import java.util.Scanner;

public class _1411 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	    //최대 50장이므로 배열을 50개 생성
	    int[] card = new int[50];

	    //카드 받기
	    for(int i = 0; i < n-1; i++){
	      card[i] = sc.nextInt();
	    }
	    //정렬 0부터 n-1까지
	    Arrays.sort(card, 0, n-1);
	    for(int i = 0; i < n; i++){      
	      //만약 카드의 i번째가 i+1이 아니거나 카드의 i번째가 0이라면 i+1을 출력
	      if(card[i] != i+1 || card[i] == 0){
	        System.out.println(i+1);
	        break;
	      }
	    }
	}
}
