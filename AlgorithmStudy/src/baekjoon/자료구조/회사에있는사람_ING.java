package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 회사에있는사람_ING {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<Employees> employee = new ArrayList<Employees>();
	final static String In = "enter";
	final static String Out = "leave";
	static int inCnt,outCnt;
	
	static class Employees {
		String name;
		String inOut;
		
		public Employees(String name, String inOut) {
			this.name = name;
			this.inOut = inOut;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		inputData();
		logic();
		//outputData();
	
		bw.flush();
		bw.close();
	}

	@SuppressWarnings("unlikely-arg-type")
	private static void logic() throws IOException {
		if(employee.contains(In)) {
			
		System.out.println(inCnt);	
		}else if(employee.contains(Out)) {
			employee.remove(Out);
			System.out.println(inCnt);
		}
		System.out.println("testIn = " + employee.contains(In));
		System.out.println("testOut = " + employee.contains(Out));
		//if(inCnt > 0) {
		for(Employees e : employee)
			if(e.inOut.equals(In) ) {
			bw.write(e.name+"\t"+e.inOut + "\n");
		}
	}

	private static void inputData() throws NumberFormatException, IOException {
		int inputNum = Integer.parseInt(br.readLine());
		
		for(int i=0;i<inputNum;i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String inOut = st.nextToken();
			
			employee.add(new Employees(name, inOut));
		}
	}
}
