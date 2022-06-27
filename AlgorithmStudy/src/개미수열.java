
public class 개미수열 {

	public static void main(String[] args) {
		 /*
		    * 문제 : 개미수열 10 줄을 출력 출력결과 : 
		    * 1            number 1   next = "" count = 0
		    * 11           number 11  next = 1 count = 1
		    * 12           number 12  next = 1 count = 2
		    * 1121
		    * 122111 
		    * 112213 
		    * 12221131 
		    * 1123123111
		    * 12213111213113 
		    * 11221131132111311231
		    */
		   
		   /*
		    * 1. 10개행이니까 10개행 포문을 돌리고
		    * 2. 문자열 길이만큼 포문을 돌리면서
		    * 3. 
		    * 4. 문자열에 있는 값을 하나씩 카운트 하면서 해당 값을 임시 변수에 값+카운트로 저장하고
		    * [1] 값1 + 카운트 1 => 11
		    * [11일때], 값 1 + 카운트 2 => 12
		    * [12일때], 값1 + 카운트1 + 값2 + 카운트1 => 1121
		    * [1121일때], 값1 + 카운트2 + 값2 + 카운트1 + 값1 + 카운트1 => 122111
		    * [122111일때], 값1 + 카운트1 + 값2 + 카운트2 + 값1 + 카운트3 => 112213
		    * [112213일때], 값1 + 카운트2 + 값2 + 카운트2 + 값1 + 카운트1 + 값3 + 카운트1 => 12221131
		    * 5. 그것을 결과 값에 넣고 출력하고, 그 결과 값에 대해 다시 숫자와 카운트를 세면서 결과 값에 새로 대입
		    * 6. 새로 대입한 결과에 대해서 2번부터 다시 실행 [문자열 길이가 새로 바뀌고, 문자열 길이만큼 다시 실행]
		    * */
		/*
		String number = "11";
		String result = "";
		for(int row=0;row<10;row++) {
			
			int count = 1;
			
			char ch = number.charAt(0);
			
			for(int i=1;i<number.length();i++) {
				if(ch == number.charAt(i)) {
					count++;
				}else {
					result = result + ch + count;
					ch = number.charAt(i);
					count = 1;
				}
			}
			result = result + ch + count;
			System.out.println(result);
			
		}
*/
		
		/*
	        String number = "1";
	        System.out.println(number);
	        for(int row=1;row<=10;row++){
	            String nextNumber = "";
	            
	            int j=0;
	            for(int i=0;i<number.length();i=j){
	            	System.out.println("i ====> " + i);
	                nextNumber = nextNumber + number.charAt(i);
	                System.out.println("누적 = " + nextNumber);
	                int count = 1;

	                for(j=i+1;j<number.length();j++){
	                	System.out.println("i , j =====> " + i + "," + j);
	                    if(number.charAt(i)==number.charAt(j)){
	                        count++;
	                    } else {
	                        break;
	                    }
	                }//3중 for
	                nextNumber = nextNumber + "" +count;

	            }//2중 for
	            
	            number = nextNumber;
	            System.out.println("결과 = " + number);
	            System.out.println();
		
	        } //10행 1중 for
		*/
		
		 	String number = "1";
		 	System.out.println(number);
		 	
	        for(int row=1;row<10;row++){ //10행
	        	System.out.println("번호 = " + row);
	        	String result = ""; //1. ""
	            int count = 1;      //count 1
	            char target = number.charAt(0); //number = "1";
	            
	            result = result + target;        //1
	            //1 
	            for(int i = 1 ; i < number.length() ; i++) { // 
	            	 // i = 2
	            	//i = 3
	                if(number.charAt(i) == target){
	                	count++; //2
	                } else {
	                	result = result + count; //12     12211
  	                    target = number.charAt(i); //2    1  
	                    result = result + target; //1221  12211
	                    count = 1; //
	                   
	                }
	            } //안의 포문
	            
	            result = result + count;
	            System.out.println("result = " + result); //1
	            number = result; //number -> 1
	        } //10행
		
		
		
		/*
		  String msg = "1";
	      String temp = "";
	      int count = 1;
	     
		      for (int row = 0; row < 10; row++) {//10행
		         for (int i = 0; i < msg.length(); i++) { //문자열 길이만큼 
		        	 
		        	 if(i == msg.length()-1 || msg.charAt(i) == msg.charAt(i+1)) {
		        		count++;
		        	 }else {
		        		 temp = msg + count;
		        		 //System.out.println("temp = " + temp);
		        		 //System.out.println("msg = " + msg);
		        	 }
		        	 temp = msg + count;
			         msg = temp; 
			         //System.out.println("temp = " + temp);
		         } 
		         //System.out.println(msg);
		       //다음행 오기전에 count,temp초기화
		         count = 1;
	        	 temp = "";
	        	
		         System.out.println(msg);
		      }//10행 for문
		            //석우왈 ] 봐야할 위치부터 같은거 나올때까지  
		            //이노왈 ] 문자열 1행 출력할 때 msg만큼 싹 훑어보고, 같은게 있으면 count++해
		            
//		        	 }else {
//		        		 temp = msg + temp + count;
//		        	 }
		            //같은게 나오면 count++;
		            //같은게 나오지 않는다면  count는 1이야 뒤에 1만 추가적으로 들어가겠지
		            //temp = msg + temp + count;
			        //msg = temp;
		        	 //System.out.println("Temp = " + temp);
		        	 
		        */
		

		   

	}
}
