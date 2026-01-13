import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());

        int[] card = new int[n];
        String[] input = buffer.readLine().split(" ");
        for(int i = 0; i<n; i++ ) card[i] = Integer.parseInt(input[i]);

        int m = Integer.parseInt(buffer.readLine());
        int[] cntCard = new int[m];
        input = buffer.readLine().split(" ");
        for(int i = 0; i<m; i++ ) cntCard[i] = Integer.parseInt(input[i]);
        Arrays.sort(card);

        for(int i = 0; i <m; i++){
            int key = cntCard[i];
            int ans = high(card,key)-low(card,key);
            sb.append(ans).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static int low(int[] arr, int key){
        int l = 0; int h = arr.length;

        while(l < h){
            int mid = (l+h)/2;

            if(key <= arr[mid]){
                h = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int high(int[] arr, int key){
        int l = 0;
        int h = arr.length;

        while(l<h){
            int mid = (l+h)/2;

            if(key < arr[mid]){
                h = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }
}
