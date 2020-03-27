package javaStudy.ch13_쓰레드;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/*
	 * fork&join -> 하나의 작업을 작은 단위로 나눠서 여러 쓰레드가 동시에 처리하는 거슬 쉽게 만들어줌
	 * fork() -> 작업을 쓰레드의 작업 큐에 넣는 것, 작업 큐에 들어간 작업은 더 이상 나눌수 없을 떄까지 나뉨
	 * 즉, compute()로 나누고 fork()로 작업 큐에 넣는 작업이 계속해서 반복됨
	 * 
	 * 
	 * fork() -> 비동기 메서드
	 * 비동기메서드 -> 일반적인 메서드와 달리 메서드를 호출만 할 뿐, 그 결과를 기다리지 않음
	 * join() -> 동기메서드
	 * p788
	 * */
public class ForkJoinEx1 {
	//ForkJoinPool -> 지정된 수의 쓰레드를 미리 만들어 놓고 반복해서 재사용할 수 있게 함
	static ForkJoinPool fp = new ForkJoinPool(); // 쓰레드풀 생성

	public static void main(String[] args) {
		
		long from = 1L;
		long to = 100_000_000L;
		
		SumTask task = new SumTask(from, to);
		//시작시간 초기화
		long start = System.currentTimeMillis();
		Long result = fp.invoke(task);
		
		System.out.println("Elapsed time(4 Core) : " + (System.currentTimeMillis() - start));
		
		System.out.printf("sum of %d~%d=%d%n", from,to,result);
		System.out.println();
		
		//result값 및 시작시간(start) 초기화
		result = 0L;
		start = System.currentTimeMillis();
		
		for(long i=from;i<to;i++)
			result += i;
		System.out.println("Elapsed time(2 Core) : " + (System.currentTimeMillis() - start));
		
		System.out.printf("sum of %d~%d=%d%n", from,to,result);
	}// main
}

//RecursiveAction -> 반환값이 없는 작업을 구현할 떄 사용
//--------------------------------------------
//위의 두 클래스 중에서 하나를 상속받아 구현해야함
class SumTask extends RecursiveTask<Long> {//RecursiveTask -> 반환값이 있는 작업을 구현할 떄 사용
	long from, to;
	
	SumTask(long from, long to) {
		this.from = from;
		this.to = to;
	}
	
	public Long compute() {
		long size = to - from + 1; //from <= i <= to
		
		if(size <= 5) //더할 숫자가 5개 이하면
		return sum(); //숫자의 합을 반환  & 반환값이 sum()이므로 반환값이 있는 작업을 구현할 떄 사용하는 RecursiveTask사용
		
		long half = (from+to)/2;
		
		//범위를 반으로 나눠서 두 개의 작업을 생성
		SumTask leftSum = new SumTask(from,half);
		SumTask rightSum = new SumTask(half+1, to);
		
		leftSum.fork(); //호출시 -> 결과를 기다리지 않고 다음 문장(return)으로 넘어감
		
		return rightSum.compute() + leftSum.join();
	}//compute()
	//------------------------------------------------------------------------------------
	long sum() { //from ~ to까지 더한 값을 반환
		long tmp = 0L;
		
		for(long i=from;i<=to;i++)
			tmp += i;
		
		return tmp;
	}//sum()
	
}// SumTask

