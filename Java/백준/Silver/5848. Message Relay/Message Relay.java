import java.util.*;
import java.io.*;

public class Main {
  static int N;
  public static void main(String[] args)throws IOException {
    
   BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
   int N = Integer.parseInt(buffer.readLine());
   boolean[] isCycle = new boolean[N+1];
   HashMap<Integer, Integer> map = new HashMap<>();
   for(int i = 0; i < N; i++){
     int n = Integer.parseInt(buffer.readLine());
     map.put(i+1, n);
   }
   int cnt = 0;
   for(int i = 1; i <= N; i++){
	   HashSet<Integer> temp = new HashSet<>();
	   int cur = i;
	   while(true) {
		   cur = map.get(cur);   
		   if(temp.contains(cur)) {
			   cnt++;
			   break;
		   }
		   if(cur == 0)break;
		   temp.add(cur);
	   }
   }
   System.out.println(N-cnt);
   
  }
}