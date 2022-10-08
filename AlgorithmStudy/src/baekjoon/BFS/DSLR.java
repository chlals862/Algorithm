package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/* D = A의 제곱
 * S = n-1   -> if n이 0일때 -> 9999가 저장
 * L = n의 각 자릿수를 왼편으로  1234 -> 3412 //    1234 -> 2341L -> 3412L   result : LL
 * R = n의 각 자릿수를 오른쪽으로  1234 -> 3412/     1234 -> 4123R -> 3412R   result : RR
 * */
/* Step1.
 * 입력받은 A(초기값)이 B(최종값)으로 바꾸기 위한 명령어 출력
 * 같을 때 까지 첫번째 idx를 마지막 idx로 이동(L) || 마지막 idx를 첫번째 idx로 이동(R)
 * 
 * 
 * D = (num * 2) % 10000;
 * S = 0 ? 9999 : num -1;
 * L = (num % 1000) * 10) + (num /1000);
 * R = (num % 10) * 1000) + (num / 10);
 * 
 * */

public class DSLR {
	static int T, A, B;
	static Queue<cal> q;
	static boolean[] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static class cal {
		int num;
		String result;

		public cal(int num, String result) {
			this.num = num;
			this.result = result;
		}
	}

	public static void main(String[] args) throws IOException {
		setData();
	}

	private static void setData() throws IOException {
		T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			q = new LinkedList<cal>();
			visit = new boolean[10000];
			visit[A] = true;
			q.add(new cal(A, ""));
			BFS();
			bw.flush();
			q.clear();
		}
		bw.close();
	}

	private static void BFS() throws IOException {
		while (!q.isEmpty()) {
			cal currentNum = q.poll();

			if (currentNum.num == B) {
				bw.write(currentNum.result + "\n");
				return;
			}
			// 수식 검색함
			if (currentNum.num * 2 < 10000) {
				int d = (currentNum.num * 2);
				if (visit[d] == false) {
					visit(d);
					q.add(new cal(d, currentNum.result + "D"));
				}
			}
			int s = currentNum.num == 0 ? 9999 : currentNum.num - 1;
			//1234 % 1000 -> 234 , 234 * 10 -> 2340 + (1234/1000 -> 1); -> 1234는 2341로
			//현재 수를 1000으로 나눈 나머지 값 * 10 + 현재 수를 1000으로 나눈 값
			int l = ((currentNum.num % 1000) * 10) + (currentNum.num / 1000);
			//1234 %10 -> 4 , 4 * 1000 -> 4000 + (1234/10 -> 123); -> 4123
			//현재 수를 10으로 나눈 나머지 값 * 1000 + 현재 수를 10으로 나눈 값
			int r = ((currentNum.num % 10) * 1000) + (currentNum.num / 10);

			if (visit[s] == false) {
				visit(s);
				q.add(new cal(s, currentNum.result + "S"));
			}
			if (visit[l] == false) {
				visit(l);
				q.add(new cal(l, currentNum.result + "L"));
			}
			if (visit[r] == false) {
				visit(r);
				q.add(new cal(r, currentNum.result + "R"));
			}
		}

	}

	private static void visit(int d) {
		visit[d] = true;
	}

}
