package 연습_재귀;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*
N*M 크기의 얼음 틀이 있습니다. 구멍이 뚫려있는 부분은 0, 
칸막이가 존재하는 부분은 1로 표시됩니다.
구멍이 뚫려 있는 부분끼리 상,하,좌,우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주
이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성.
ex) 00110
    00011
    11111
    00000 -> 총 3개의 아이스크림 생성

입력 예시
4 5
00110
00011
11111
00000

문제 해결 아이디어
DFS를 활용하는 알고리즘은 다음과 같다.
1. 특정한 지점의 주변 상,하,좌,우를 살펴본 뒤에 주변 지점 중에서 값이 '0'이면서 아직 방문
       하지 않은 지점이 있다면 해당 지점을 방문
2. 방문한 지점에서 다시 상,하,좌,우를 살펴보면서 방문을 진행하는 과정을 반복하면,
       연결된 모든 지점을 방문할 수 있다.
3. 모든 노드에 대하여 1~2번의 과정을 반복하며, 방문하지 않은 지점의 수를 카운트한다.
*/
public class 음료수얼려먹기 {
	static int R,C;
	static int[][] map;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	//DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
	private static boolean dfs(int row, int col) {
		//주어진 범위를 벗어나는 경우에는 즉시 종료
		if(row <= -1 || row >= R || col <= -1 || col >= C) return false;
		
		//현재 노드를 아직 방문하지 않았다면
		if(map[row][col] == 0) {
			//해당 노드 방문 처리
			map[row][col] = 1;
			//상,하,좌,우의 위치들도 모두 재귀적으로 호출
			dfs(row-1,col); //상
			dfs(row+1,col); //하
			dfs(row,col-1); //좌
			dfs(row,col+1); //우
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int row=0;row<R;row++) {
			String str = br.readLine();
			for(int col=0;col<C;col++) {
				map[row][col] = str.charAt(col) - '0';
			}
		}
		
		//모든 노드(위치)에 대하여 음료수 채우기
		int result = 0;
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				//현재 위치에서 DFS 수행
				if(dfs(row,col)) { //true면
					result += 1;
				}
			}
		}
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}
	
}
