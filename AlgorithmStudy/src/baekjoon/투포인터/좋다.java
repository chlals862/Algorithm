package baekjoon.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 투 포인터 i,j를 배열 A 양쪽 끝에 위치시키고 조건에 적합한 투 포인터 원칙을 활용 
 * K -> 판별의 대상 되는 수
 * A[i] + A[j] < K -> j--  |  A[i] + A[j] < K -> i++
 * A[i] + A[j] == K -> i++ j-- count++
 * 
 * */
public class 좋다 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		long A[] = new long[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(A);
		
		for(int k=0;k<N;k++) {
			long find = A[k];
			int i = 0;
			int j = N-1;
			
			//투 포인터
			while(i < j) {
				if(A[i] + A[j] == find) {
					//find는 서로 다른 두 수의 합이어야 함을 체크
					if( i!= k && j != k) {
						result++;
						break;
					} else if(i == k) {
						i++;
					} else if(j == k) {
						j--;
					}
				} else if(A[i] + A[j] < find) {
					i++;
				} else {
					j--;
				}
			}
		}
		bw.write(result+"");
		bw.flush();
	}

}
