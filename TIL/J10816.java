package TIL;

import java.io.*;
import java.util.*;

public class J10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        int[] card = new int[n];
        String[] input = buffer.readLine().split(" ");
        for(int i = 0; i<n; i++ ) card[i] = Integer.parseInt(input[i]);

        int m = Integer.parseInt(buffer.readLine());
        int[] cntCard = new int[m];
        input = buffer.readLine().split(" ");
        for(int i = 0; i<m; i++ ) cntCard[i] = Integer.parseInt(input[i]);
        Arrays.sort(card);

        for(int i = 0; i< m; i++){
            boolean isHas = false;
            int start = 0;
            int end = n-1;
            int key = cntCard[i];

            while(start <= end){
                int mid = (start + end)/2;
                if(card[mid]>key){
                    end = mid-1;
                } else if (card[mid]<key) {
                    start = mid+1;
                }
                else {
                    isHas = true;
                    break;
                }
            }
            if(isHas)System.out.print("1"+ " ");
            else System.out.print("0"+ " ");
        }
    }

    public static int low(int[] arr, int key){
        int l = 0;
        int h = arr.length;

        while(l<h){
            int mid =(l + h)/2;

            if(key<arr[mid]){
                h = mid;
            }else {
                l = mid +1;
            }
        }
        return l;
    }
    public static int high(int[] arr, int key){
        int l = 0;
        int h = arr.length;

        while(l<h){
            int mid = (l+h)/2;
            if(key <= arr[mid]){
                h = mid;
            }else{
                l = mid +1;
            }

        }
        return l;
    }
}
