package 카카오코테2022;

import java.io.IOException;


public class _1번 {
	public static void main(String[] args) throws IOException {
		
		//solution( "2022.05.19", 
		//new String[]{"A 6", "B 12", "C 3"}, 
		//new String[] {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		System.out.println(today);
		
		
		for(int row=0;row<privacies.length;row++) {
			System.out.println(privacies[row]);
		}
		
		
	}
}
