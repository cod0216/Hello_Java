package TIL;
import java.util.*;
import java.io.*;
public class J1920_0 {

    public static void main(String[] args) throws IOException{

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int Num = Integer.parseInt(buffer.readLine());
        String[] input = buffer.readLine().split(" ");

        int[] arr1 = new int[Num];
        for(int i = 0; i < Num; i++){
            arr1[i] = Integer.parseInt(input[i]);
        }
        int num = Integer.parseInt(buffer.readLine());
        input = buffer.readLine().split(" ");
        int[] arr2 = new int[num];
        for(int i = 0; i< num; i++){
            arr2[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr1);
        for(int i = 0; i <num; i++){
            int start = 0;
            int end = Num-1;
            int key = arr2[i];
            int answer = 0;
            while(end >start){
                int index = (start + end)/2;
                if (key < arr1[index]) {
                    end = index-1;
                } else if (key> arr1[index]){
                    start = index+1;
                }
                else{
                    answer =1;
                    break;
                }

            }
            if(answer == 0){
                System.out.println("0");
            }
            if(answer == 1){
                System.out.println("1");
            }
        }

    }
}
