
public class 통곡의벽 {
	public static void main(String[] args) {
	 String number = "1";
     System.out.println(number);
     for(int row=1;row<=10;row++){ //10행
        String nextNumber = "";
        // int count = 0;
         int count = 1;
         //int characterIndex = 0;
         //char target = number.charAt(characterIndex); //number = "1";
         char target = number.charAt(0);
         nextNumber += target;        //"" + 1
         
         //while(characterIndex < number.length() ) { // 0 < 1
            for(int i=1; i<number.length();i++) {
            //1 == 1 || 0 == 1
            // if(nextNumber.charAt(characterIndex) == target || characterIndex == number.length()){
                 if(number.charAt(i) == target) {
                 count++; //1
                 //characterIndex++; //1
             } else {
                 //System.out.println("발견");
                 nextNumber += Integer.toString(count);
                 target = number.charAt(i);
                 //count = 0;
                 //추가
                 nextNumber = nextNumber + target;
                 count = 1;
             }
         } //while
          //1
         //number += count; //number -> 1
         nextNumber += count;
            System.out.println(nextNumber);
         //추가
         number = nextNumber;
     } //10행
	}
}
