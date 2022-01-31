package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
[input]
4 3
10 3
100 5
[output]
5
14
124
*/
public class 치킨쿠폰 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		while(true) {
			String str = br.readLine();
			if(str == null) break;
			String[] arr = str.split(" ");
			int coupon = Integer.parseInt(arr[0]);
			int stamp = Integer.parseInt(arr[1]);
			int cnt = 0; int nCoupon; int newCnt;
			while(true) {
				newCnt = (coupon - coupon%stamp);
				nCoupon = newCnt/stamp;
				coupon = coupon%stamp;
				coupon += nCoupon;
				cnt += newCnt;
				if(coupon < stamp) {
					cnt += coupon;
					break;
				}
			}
			System.out.println(cnt);
		}
		
	}
	
}


