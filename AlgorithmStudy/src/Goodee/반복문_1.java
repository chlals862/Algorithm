package Goodee;

public class 반복문_1 {

	public static void main(String[] args) {
		  for (int i = 0; i < 5; i++) {
		         for (int j = 0; j < 5; j++) {
		            System.out.print("*");
		         }
		         System.out.println();
		      }
//		        *
//		        **
//		        ***
//		        ****
//		        *****
		      System.out.println("---------------");
		      for (int i = 0; i < 5; i++) {
		         for (int j = 0; j < i+1; j++) {
		            System.out.print("*");
		         }
		         System.out.println();
		      }
//		      *****
//		      ****
//		      ***
//		      **
//		      *
		      System.out.println("---------------");
		      for (int i = 0; i < 5; i++) {
		         for (int j = 0; j < 5-i; j++) {
		            System.out.print("*");
		         }
		         System.out.println();
		      }
//		               *
//		              **
//		             ***
//		            ****
//		           *****
		      System.out.println("---------------");
		      for (int i = 0; i < 5; i++) {
		         for (int j = 0; j < 4 - i; j++) {
		            System.out.print(" "); //4칸 공백 + 1칸 별
		         }                     //3칸 공백 + 2칸 별 
		                               // .. 0칸 공백 + 5칸 별
		         for (int j = 0; j < 1 + i; j++) {
		            System.out.print("*");
		         }
		         System.out.println("");
		      }

//		         *****
//		          ****
//		           ***
//		            **
//		             *
		      System.out.println("---------------");
		      
		      for (int i = 0; i < 5; i++) {
		         for (int j = 0; j < i; j++) {
		            System.out.print(" ");
		         }
		         for (int j = 0; j < 5 - i; j++) {
		            System.out.print("*");
		         }
		         System.out.println("");
		      }
		      
		      //System.out.println("-----------");

//		      for (int i = 0; i < 5; i++) {
//		         for (int j = 0; j < 5; j++) {
//		            if (j < 0 + i)
//		               System.out.print(" ");
//		            else {
//		               System.out.print("*");
//		            }
//		         }
//		         System.out.println("");
//		      }

		      for(int i=0;i<5;i++) { //5
		         for(int j=0;j<5;j++) { //5
		            if(j > i) { // 공백에 대한 조건
		               System.out.print(" "); //25
		            } else { //별
		               System.out.print("*"); //25
		            }
		         }
		         System.out.println();
		      }
		      System.out.println("------------------------");
		      System.out.println("6번");
		      //공백 4 , 별1 , 공백 4
		      //공백 3 , 별3 , 공백 3
		      //공백 2 , 별5 , 공백 2
		      //공백 1 , 별7 , 공백 1
		      //공백 0 , 별9 , 공백 0
		      for(int i = 0; i<5;i++) {
		         for (int j = 0; j < 4 - i; j++) {
		            System.out.print("-"); 
		         }
		         for (int j = 0; j < i; j++) {
		            System.out.print("*");
		         }
		         for (int j = 0; j <= i; j++) {
		            System.out.print("*");
		         }
		         for(int j=0;j<4-i;j++) {
		            System.out.print("-");
		         }
		         System.out.println();
		      }
		      
		      System.out.println("------------------------");
		      System.out.println("7번");
		      //공백 0 , 별9 , 공백 0
		      //공백 1 , 별7 , 공백 1
		      //공백 2 , 별5 , 공백 2
		      //공백 3 , 별3 , 공백 3
		      //공백 4 , 별1 , 공백 4
		      for(int row=5;row>0;row--) {
		    	   for(int col=0;col<5-row;col++) {
		    		   System.out.print("-");
		    	   }
		    	   for(int col=0;col<row*2-1;col++) {
		    		   System.out.print("*");
		    	   }
		    	   for(int col=0;col<5-row;col++) {
		    		   System.out.print("-");
		    	   }
		    	   System.out.println();
		       }
		      
		      System.out.println();
		      System.out.println("------------------------");
		      System.out.println("8번");
		      //공백4 , 별1 , 공백 4
		      //공백3 , 별3 , 공백 3
		      //공백2 , 별5 , 공백 2
		      //공백1 , 별7 , 공백 1 
		      //공백0 , 별9 , 공백 0
		      //공백1 , 별7 , 공백 1
		      //공백2 , 별5 , 공백 2
		      //공백3 , 별3 , 공백 3
		      //공백4 , 별1 , 공백4
		      
		       for(int row=1;row<=5;row++) {
		    	   for(int col=0;col<5-row; col++) {
		    		   System.out.print("-");
		    	   }
		    	   for(int col=0;col<row*2-1;col++) {
	    			   System.out.print("*");
	    		   }
		    	   for(int col=0;col<5-row;col++) {
		    		   System.out.print("-");
		    	   }
		    	   System.out.println();
		       }
		       
		       for(int row=4;row>0;row--) {
		    	   for(int col=0;col<5-row;col++) {
		    		   System.out.print("-");
		    	   }
		    	   for(int col=0;col<row*2-1;col++) {
		    		   System.out.print("*");
		    	   }
		    	   for(int col=0;col<5-row;col++) {
		    		   System.out.print("-");
		    	   }
		    	   System.out.println();
		       }
		      
		      
		      
		      


	}

}
