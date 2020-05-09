import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기2 {
	static int R,C;
	static int K,ans=100000;
	static int map[][];
	static boolean[][][] visited;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static class Node{
		int x;
		int y;
		int crash;
		int dist;
		
		public Node(int _x, int _y, int _crash, int _dist) {
			this.x = _x;
			this.y = _y;
			this.crash = _crash;
			this.dist = _dist;
		}
		
	}
	public static void main(String args[]) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean [R][C][K+1];
		
		for(int i =0; i<R; i++) {
			String s = br.readLine();
			for(int j =0; j<C; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		bfs();
		bw.write(ans+"\n");
		bw.flush();
	}
	
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		
		q.add(new Node(0,0,K,1));
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			visited[temp.x][temp.y][temp.crash] = true;
			
			if(temp.x == R-1 && temp.y == C-1) {  //마지막 좌표과 왼쪽, 위 2가지 경우존재
				ans = Math.min(ans, temp.dist);
				break;
			}
			
			
			for(int dir =0; dir<4; dir++) {
				int nr = temp.x +dr[dir];
				int nc = temp.y +dc[dir];
				
				if(nr <0 || nr >= R || nc<0 || nc>= C) continue;
				if(map[nr][nc] == 0 && visited[nr][nc][temp.crash] == false) {
					visited[nr][nc][temp.crash] =true;
					q.add(new Node(nr,nc,temp.crash,temp.dist+1));
				}
				if(map[nr][nc] == 1 && visited[nr][nc][temp.crash] == false) {
					if(temp.crash >0) {
						
						visited[nr][nc][temp.crash] = true;
						q.add(new Node(nr,nc,temp.crash-1, temp.dist+1));
						//System.out.println("crash = " + temp.crash);
						//map[nr][nc] = 0;
					}
				}
			}
		}
		//큐가 더이상 없을떄
        //ans 값 안바꼇네???  최종좌표 도달 못했네? 
		if(ans == 100000)
			ans = -1;
	}
}

