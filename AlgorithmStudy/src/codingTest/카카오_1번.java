package codingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 카카오_1번 {
	static char[][] numbers;
	static String inputNum;
	static char[] numarr;
	static boolean[][] Lvisit;
	static boolean[][] Rvisit;
	static String hand;
	static int lcnt, rcnt;
	static ArrayList<String> result = new ArrayList<String>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static Queue<int[]> q = new LinkedList<int[]>();
	// static Queue<int[]> rightQ = new LinkedList<int[]>();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		inputData();
		setData();
	}

	private static void setData() {
		for (int i = 0; i < numarr.length; i++) {
			switch (numarr[i]) {
			case '1':
			case '4':
			case '7':
				result.add("L");
				break;
			case '3':
			case '6':
			case '9':
				result.add("R");
				break;

			case '2':
			case '5':
			case '8':
			case '0':
				BFS();
				System.out.println(result);
				break;
			}
		}
	}

	private static void BFS() {

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentLeft = q.poll();
				int currentR = currentLeft[0];
				int currentC = currentLeft[1];

				for (int dir = 0; dir < 4; dir++) {
					int lnr = currentR + dr[dir];
					int lnc = currentC + dc[dir];

					if (rangeCheck(lnr, lnc)) {
						if (Lvisit[lnr][lnc] == false && numbers[lnr][lnc] != '3' && numbers[lnr][lnc] != '6'
								&& numbers[lnr][lnc] != '9') {

							q.add(new int[] { lnr, lnc });
							Lvisit[lnr][lnc] = true;
							result.add("L");
							lcnt++;
						}
					}
					if (rangeCheck(lnr, lnc)) {
						if (Lvisit[lnr][lnc] == false && numbers[lnr][lnc] != '1' && numbers[lnr][lnc] != '4'
								&& numbers[lnr][lnc] != '7') {
							q.add(new int[] { lnr, lnc });
							Rvisit[lnr][lnc] = true;
							result.add("R");
							rcnt++;
						}
					}
				}
			}
			if (lcnt == rcnt) {
				if (hand.equals("right")) {
					result.add("R");
				}else if(hand.equals("left")) {
					result.add("L");
				}
			}
		}

	}

	private static void inputData() throws IOException {
		// st = new StringTokenizer(br.readLine());
		Scanner sc = new Scanner(System.in);
		numarr = new char[1001];
		numbers = new char[1001][1001];
		Lvisit = new boolean[4][4];
		Rvisit = new boolean[4][4];
		inputNum = sc.nextLine();
//		for (int i = 0; i < inputNum.length(); i++) {
//			inputNum.split("[");
//			inputNum.split("]");
//			inputNum.split(", ");
//			numarr[i] = inputNum.charAt(i);
//			System.out.print(numarr[i]);
//		}

		hand = sc.nextLine(); // 손잡이 입력
		sc.nextLine();
		// 스캐너 입력
		numbers[0][0] = '1';
		numbers[0][1] = '2';
		numbers[0][2] = '3';
		numbers[1][0] = '4';
		numbers[1][1] = '5';
		numbers[1][2] = '6';
		numbers[2][0] = '7';
		numbers[2][1] = '8';
		numbers[2][2] = '9';
		numbers[3][0] = '*';
		numbers[3][1] = '0';
		numbers[3][2] = '#';
		view();

		// String sLine = sc.nextLine();
		// st = new StringTokenizer(sLine,",");
		// System.out.println(st.toString());

		for (int row = 0; row < numbers.length; row++) {
			for (int col = 0; col < numbers.length; col++) {
				if (numbers[row][col] == '*') {
					q.add(new int[] { row, col });
					Lvisit[row][col] = true;
					System.out.println("왼손 = " + "row = " + row + " col = " + col);
				}
				if (numbers[row][col] == '#') {
					q.add(new int[] { row, col });
					Rvisit[row][col] = true;
					System.out.println("오른손 = " + "row = " + row + " col = " + col);
				}
			}
		}
	}

	private static boolean rangeCheck(int lnr, int lnc) {
		if (lnr >= 0 && lnr < 4 && lnc >= 0 && lnc < 5)
			return true;
		return false;
	}

	private static void view() {
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 3; col++) {
				System.out.print(numbers[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}
}
