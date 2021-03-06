package baekjoon.재귀;

import java.util.Scanner;
/*
 * 분 석 대 상
 */
public class 별 {
   static int N;
   static char[][] starMap;
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      int height = (int) Math.pow(2,N);
      starMap = new char[height][height];
      for(int row=0;row<height;row++) {
         for(int col=0;col<height;col++) {
            starMap[row][col] =' ';
         }
      }
      recursive(0,0,height);
      //System.out.println("공백의 아스키코드값:"+(int)' ');
      //System.out.println("char 디폴트 값은 아스키값이 0인 Null");
      int cnt=0;
      for(int row=height-1;row>=0;row--){
         for(int col=height-1;col>=cnt;col--) {
            System.out.print(starMap[row][col]);
         }
         cnt++;
         System.out.println();
      }
   }
   private static void recursive(int row, int col, int height) {
      if(height==1) {
         starMap[row][col]='*';
         return;
      }
      height/=2;
      recursive(row+height,col,height);
      recursive(row,col+height,height);
      recursive(row+height,col+height,height);
   }
}