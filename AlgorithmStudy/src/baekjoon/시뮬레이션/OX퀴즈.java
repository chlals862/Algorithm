package baekjoon.시뮬레이션;

import java.io.IOException;
import java.util.Scanner;

/*"OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다.
O는 문제를 맞은 것이고, X는 문제를 틀린 것이다.
문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다.
예를 들어, 10번 문제의 점수는 3이 된다.
"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.*/
public class OX퀴즈 {

	// static BufferedReader br = new BufferedReader(new
	// InputStreamReader(System.in));
	// static BufferedWriter bw = new BufferedWriter(new
	// OutputStreamWriter(System.out));
	static int sum = 0;
	static int num;
	// static int num[];
	// static ArrayList<String> list = new ArrayList<String>();
	static String[] list;
	//static char[] ch;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();

		list = new String[80];
		sc.nextLine();
		//리스트로 받아서 하나씩 검사하면서 'O'이면 sum += sum;
		for (int i = 0; i < input; i++) {
			String s = sc.nextLine();
			//list[i] = s;
			sum = 0;
			num = 0;
			for (int j=0; j < s.length(); j++) {
				char ch = s.charAt(j);
				
				if(ch == 'O') {
					num++;
					sum += num;
					
				}else if(ch == 'X') {
					num = 0;
				}
			}
			System.out.println(sum);
		} // for
		//System.out.println(sum);
		/*
		 * sc.nextLine(); for(int i=0;i<=input;i++) { String s = sc.nextLine();
		 * //System.out.println("s="+s); //sc.nextLine(); list[i] = s;
		 * //System.out.println("list[i] = "+ list[i]);
		 * 
		 * 
		 * for(int j=i;j<list.length;j++) { //System.out.println("ㅇㅅㅇ");
		 * if(list[i].charAt(j) == 'O') { num++; sum += num; } else if(list[i].charAt(j)
		 * == 'X') { num = 0; } } } System.out.println("sum = " + sum);
		 * 
		 * //for(int i=0;i<list.size();i++) { //}
		 * 
		 * sc.nextLine(); char ch = s.charAt(i); if(ch == 'O') {
		 * System.out.println("O가있다."); }
		 */
	}
}
