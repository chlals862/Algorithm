package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
------------------------------
10 2
.L
..
XX
XX
XX
XX
XX
XX
..
.L

3
------------------------------
4 11
..XXX...X..
.X.XXX...L.
....XXX..X.
X.L..XXX...

2
------------------------------
8 17
...XXXXXX..XX.XXX
....XXXXXXXXX.XXX
...XXXXXXXXXXXX..
..XXXXX.LXXXXXX..
.XXXXXX..XXXXXX..
XXXXXXX...XXXX...
..XXXXX...XXX....
....XXXXX.XXXL...

2
------------------------------
1 7
LXX.XXL

1
 * */


/*
 * 시간초과를 때문에 백조와 물 확장 BFS를 동시에 진행
 * BFS 탐색은 다음날이 되어 새롭게 이동가능한 좌표들로만 진행
 * */
public class 백조의호수 {
	static int R, C, res;
	static char[][] sea;
	static boolean[][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<int[]> swan, water; //백조의 좌표와, 물의 이동가능한 좌표 담기
	static ArrayList<int[]> swans; //백조의 위치 담기
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		sea = new char[R][C];
		visit = new boolean[R][C];
		swan = new LinkedList<int[]>();
		water = new LinkedList<int[]>();
		swans = new ArrayList<int[]>();

		for (int row = 0; row < R; row++)
			sea[row] = br.readLine().toCharArray();
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (sea[row][col] == 'L') {
					// 오리 위치 저장후, 오리 위치도 물이니까 물로 변환
					swans.add(new int[] { row, col });
					water.add(new int[] { row, col }); // 오리자리가 물로 바뀌었으니 물전용 큐에 넣기
					sea[row][col] = '.';
				} else if (sea[row][col] == '.')
					water.add(new int[] { row, col });
			}
		}

		int[] startSwan = swans.get(0); //백조 두 마리의 좌표를 담고 있는 swans 리스트에서 0번째 좌표 하나를 꺼내서 시작 지점으로 설정
										//이 좌표에 대한 방문 처리를 한 후, swan 큐에 담아 BFS탐색
		swan.add(startSwan);
		visit[startSwan[0]][startSwan[1]] = true; // 첫 오리 출발 및 방문처리

		while (true) {
			boolean flag = false; //다른 백조를 만날경우 무한 루프에서 빠져나오기
			Queue<int[]> q = new LinkedList<int[]>(); // 미리 좌표를 저장하여 다음 탐색의 시작점이 될 큐
			while (!swan.isEmpty()) {
				int[] current = swan.poll();
				int cr = current[0];
				int cc = current[1];
					//cr,cc는 출발한 백조 -> get(0)[0],(0)[1] 
					//	           도착할 백조 -> get(1)[0],(1)[1]
				if (cr == swans.get(1)[0] && cc == swans.get(1)[1]) {
					flag = true;
					break;
				}

				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc) && !visit[nr][nc]) {
						//이동할 좌표에 물이 위치하면 swan큐에 담아 이동을 계속함
						visit[nr][nc] = true;
						if (sea[nr][nc] == '.') {
							swan.add(new int[] { nr, nc });
						}
						//이동할 좌표에 빙판이 있다면,초기에 비어있는 q에 저장
						else if (sea[nr][nc] == 'X') q.add(new int[] { nr, nc });
					}
				}
		}
			if(flag) break;
			swan = q; //백조의 시작지점을 위에 빙판이 곧 물로 될 위치에서 시작★★★★★
			
			//물 확장시키기
			int waterSize = water.size();
			for(int i=0;i<waterSize;i++) {
				int[] current = water.poll();
				int cr = current[0];
				int cc = current[1];
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(sea[nr][nc] == 'X') {
							sea[nr][nc] = '.';
							water.add(new int[] {nr,nc});
						}
					}
				}
				
			}
			res++;
		}
		bw.write(res+"\n");
		bw.flush();
		bw.close();
	}

	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
}
