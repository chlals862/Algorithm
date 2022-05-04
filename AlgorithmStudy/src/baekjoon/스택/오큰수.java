package baekjoon.스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n]; //수열 배열
		int[] ans = new int[n]; //정답 배열
		String[] str = br.readLine().split(" ");
		
		for(int i=0;i<n;i++) {
			A[i] = Integer.parseInt(str[i]);
		}
		Stack<Integer> myStack = new Stack<>();
		myStack.push(0); //처음에는 항상 스택이 비어 있으므로 최초 값을 push해 초기화
		
		//스택이 비어있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
		for(int i=1; i<n; i++) {
			while(!myStack.isEmpty() && A[myStack.peek()] < A[i]) {
				ans[myStack.pop()] = A[i]; //정답 배열에 오큰수를 현재 수열로 저장
			}
			myStack.push(i); //신규 데이터 push
		}
		
		while(!myStack.empty()) {
			//반복문을 다 돌고 나왔는데 스택이 비어 있지 않다면 빌때까지
			ans[myStack.pop()] = -1; //스택에 쌓인 index에 -1을 넣고
		}
		
		for(int i=0;i<n;i++) {
			bw.write(ans[i]+" ");
		}
		bw.write("\n");
		bw.flush();
	}

}
