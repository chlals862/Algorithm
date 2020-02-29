package javaCrystallization.ch5_배열;

public class ArrayEx10_버블정렬 {
	/*
	 * 버블정렬 오름차순 
	 * 인접한 두 수를 비교하여 큰 수를 뒤로 보냄
	 * 
	 * 버블정렬 내림차순
	 * 인접한 두 수를 비교하여 작은 수를 뒤로 보냄
	 * */
	public static void main(String[] args) {
		
		int[] numArr = new int[10];
		
		for(int i=0; i<numArr.length;i++) {
			System.out.print(numArr[i] = (int)(Math.random() * 10));
			/*
			 * 위의 문장은 numArr[i] = (int)(Math.random() * 10);
			 * System.out.print(numArr[i]를 한문장으로 합침
			 * */
		}//for of end
		System.out.println();
		
		for(int i=0; i<numArr.length-1;i++) {
			boolean changed = false; //자리바꿈 체크 여부
			
			for(int j=0; j<numArr.length-1-i;j++) { /*
			* 원래는 배열의 길이에서 1이작은 numArr.length-1을 비교해야 하지만
			* 매 반복마다 ★★비교횟수가 1씩 줄어들기 때문에 바깥쪽 for문의 제어변수 i를 배줌
			*/
				if(numArr[j] > numArr[j+1]) { //옆의 값이 작으면 서로 바꿈★★   j+1은 인덱스 값
					int temp = numArr[j]; //임시변수 temp에 numArr[j]저장
					numArr[j] = numArr[j+1]; //우측의 값이 작았으므로 numArr[j+1]의 값을 numArr[j]에 저장
					numArr[j+1] = temp;
					changed = true; //자리바꿈이 발생했으니 changed를 true로 변경
					}//if of end
				}//for of end j
				if(!changed) break; //changed가 발생하지 않으면 break
				
				for(int k=0; k<numArr.length;k++) 
					System.out.print(numArr[k]);
					System.out.println();
			}//for of end i
		}//main of end		
	}