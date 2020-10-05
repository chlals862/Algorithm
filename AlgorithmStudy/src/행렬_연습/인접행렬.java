package 행렬_연습;

public class 인접행렬 {
	static final int INF = 999999999;
	static int[][] graph = { 
			{0,7,5},
			{7,0,INF},
			{5,INF,0}
	};
	public static void main(String[] args) {
		//그래프 출력
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(graph[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
