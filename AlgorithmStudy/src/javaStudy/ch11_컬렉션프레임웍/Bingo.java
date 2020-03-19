package javaStudy.ch11_컬렉션프레임웍;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Bingo {
	/*
	 * 1~50사이의 숫자 중에서 25개를 골라서 5X5크기의 빙고판을 만드는 예제
	 * */
	
	public static void main(String[] args) {
		
		//Set set = new HashSet(); //-> HashSet은 저장된 순서를 보장하지 않고 자체적인 저장방식에 따라 순서가 결정되기 떄문에
		//이 경우에는 HashSet보다는 LinkedHashSet이 더 나은 선택
		Set set = new LinkedHashSet();
		int[][] board = new int[5][5];
		
		for(int i=0;set.size()<25;i++) { 
			set.add((int)(Math.random()*50)+1+"");
		}
		
		Iterator it = set.iterator();
		
		for(int i=0; i<board.length;i++) {
			for(int j=0; j<board[i].length;j++) {
				board[i][j] = Integer.parseInt((String)it.next());//next()는 반환값이 Object타입이므로 형변환해서 원래의 타입으로 되돌려 놓아야 함
				System.out.print((board[i][j] < 10 ? " " : " ") + board[i][j]);
			}
			System.out.println();
		}
		
	}
}
