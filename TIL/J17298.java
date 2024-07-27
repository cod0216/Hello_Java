package TIL;

import java.util.*;
import java.io.*;
public class J17298 {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader (System.in));
        Deque<Integer> stack = new ArrayDeque<>();
        int num = Integer.parseInt(buffer.readLine());
        String[] input= buffer.readLine().split(" ");
        int[] arr = new int[num];
        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(input[i]);
        }


        for(int i = 0; i< num; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }
        StringBuffer b = new StringBuffer();
        for(int i = 0; i <num; i++){
            b.append(arr[i] + " ");
        }
        System.out.println(b.toString());
    }
    public static void main1(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader (System.in));

        int num = Integer.parseInt(buffer.readLine());
        String[] input= buffer.readLine().split(" ");
        int max = -1;
        int[] arr = new int[num];
        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(input[i]);
        }


        for(int i = 0 ; i< num; i++){
            if(i == num-1){
                System.out.println(-1);
                continue;
            }
            if(max >arr[i]){
                System.out.print(max + " ");
            }
            else{
                for(int j = i+1; j< num; j++) {
                    if(arr[i]< arr[j] ) {
                        max = Math.max(arr[i], arr[j]);
                        break;
                    }
                }
                System.out.print(max + " ");
            }
        }
    }
}
