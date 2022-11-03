import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TestClass {

   public static void main(String[] args) throws IOException {
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringBuilder sbsb = new StringBuilder();
      
      int sum = GetRev(br.readLine());
      bw.write(Integer.parseInt(sbsb.append(sum).reverse().toString())+"\n");
      bw.flush();
   }
   
   public static int GetRev(String str) {
      StringTokenizer st = new StringTokenizer(str);
      
      StringBuilder sbx = new StringBuilder();
      StringBuilder sby = new StringBuilder();
      
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      
      sbx.append(x).reverse();
      sby.append(y).reverse();
      
      int sum = 0; 
      
      sum = Integer.parseInt(sbx.toString()) + Integer.parseInt(sby.toString());
  
      return sum;
   }
}