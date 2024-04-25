package TIL.review;
import java.util.*;
import java.io.*;
public class J1920 {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int index = Integer.parseInt(buffer.readLine());
        int[] Array = new int[index];

        String[] input = buffer.readLine().split(" ");

        for(int i = 0; i< index; i++){
            Array[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(Array);
        int findIndex = Integer.parseInt(buffer.readLine());
        int[] findArray = new int[findIndex];

        input = buffer.readLine().split(" ");

        for(int i = 0; i< findIndex; i++){
           findArray[i] = Integer.parseInt(input[i]);
        }

        for(int i = 0; i < findIndex; i++) {
            int start = 0;
            int end = index-1;
            int key = findArray[i];
            int find = 0;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (key > Array[mid]){
                    start = mid+1;
                } else if(key < Array[mid]){
                    end = mid-1;
                } else {
                    find = 1;
                    break;
                }
            }
            if (find == 1)System.out.println("1");
            else if(find == 0) System.out.println("0");
        }

    }

}
