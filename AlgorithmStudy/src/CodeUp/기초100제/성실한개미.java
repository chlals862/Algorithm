package CodeUp.기초100제;

import java.util.Scanner;

/*
영일이는 생명과학에 관심이 생겨 왕개미를 연구하고 있었다.

왕개미를 유심히 살펴보던 중 특별히 성실해 보이는 개미가 있었는데,
그 개미는 개미굴에서 나와 먹이까지 가장 빠른 길로 이동하는 것이었다.

개미는 오른쪽으로 움직이다가 벽을 만나면 아래쪽으로 움직여 가장 빠른 길로 움직였다.
(오른쪽에 길이 나타나면 다시 오른쪽으로 움직인다.)

이에 호기심이 생긴 영일이는 그 개미를 미로 상자에 넣고 살펴보기 시작하였다.

미로 상자에 넣은 개미는 먹이를 찾았거나, 더 이상 움직일 수 없을 때까지
오른쪽 또는 아래쪽으로만 움직였다.

미로 상자의 구조가 0(갈 수 있는 곳), 1(벽 또는 장애물)로 주어지고,
먹이가 2로 주어질 때, 성실한 개미의 이동 경로를 예상해보자.

단, 맨 아래의 가장 오른쪽에 도착한 경우, 더 이상 움직일 수 없는 경우, 먹이를 찾은 경우에는
더이상 이동하지 않고 그 곳에 머무른다고 가정한다.

미로 상자의 테두리는 모두 벽으로 되어 있으며,
개미집은 반드시 (2, 2)에 존재하기 때문에 개미는 (2, 2)에서 출발한다.
 * */
public class 성실한개미 {
	//0 -> 갈 수 있는곳 | 1 -> 벽 또는 장애물 | 2 -> 먹이 | 9 -> 개미가 이동한 경로
	static int[][] maze = new int[11][11];
	//오른쪽이동[열]
	static int[] dr = {0,1};
	//아래로이동[행]
	static int[] dc = {1,0};
	
	public static void main(String[] args) {
		setData();
		
		antMove();
		
		printAnswer();
		
	}
	private static void printAnswer() {
		for(int row = 1; row <= 10; row++) {
			for(int col = 1; col <= 10; col++) {
				System.out.print(maze[row][col]+" ");
			}
			System.out.println();
		}
	}
	private static void antMove() {
		//currentR,C -> 개미 시작 위치 2행 2열
		int currentR = 2;
		int currentC = 2;
		
		//먹이 ->2를 만나면 9로 바꾸고 리턴 -> 개미시작 지점에 바로 먹이가 있을 수 있으니 예외처리
		if(maze[currentR][currentC]==2){
			maze[currentR][currentC] = 9;
			return;
		}
		//개미 시작점 9로 바꿔주기
		maze[currentR][currentC] = 9;
		
		int nextR = currentR;
		int nextC = currentC;
		
		while(true){
			if(rangeCheck(nextR+dr[0],nextC+dc[0])){ //오른쪽
				nextR+=dr[0];
				nextC+=dc[0];
				
				if(maze[nextR][nextC]==0) {
					maze[nextR][nextC]=9;
					continue;
				}else if(maze[nextR][nextC]==2) {
					maze[nextR][nextC]=9;
					return;
				}
			}
			
			else if(rangeCheck(nextR+dr[1],nextC+dc[1])){ //아래쪽
				nextR+=dr[1];
				nextC+=dc[1];
				if(maze[nextR][nextC]==0) {
					maze[nextR][nextC]=9;
					continue;
				}else if(maze[nextR][nextC]==2) {
					maze[nextR][nextC]=9;
					return;
				}
			}else return;
		}//while
	}
	//미로 크기를 벗어 나면 false, 벗어나지 않았을 때 nr,nc 매개변수로 받고 [nr][nc]가 1이 아닐때 rangeCheck 수행
	private static boolean rangeCheck(int nr, int nc) {
		if(nr<=10 && nc<=10) {
			if(maze[nr][nc]!=1) return true;
		}
		return false;
	}
	private static void setData() {
		Scanner sc = new Scanner(System.in);
		for(int row = 1; row <= 10; row++) {
			for(int col = 1; col <= 10; col++) {
				maze[row][col] = sc.nextInt();
			}
		}
		
	}
}
