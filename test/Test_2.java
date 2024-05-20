import java.io.*;
import java.util.*;


public class Test_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());

        int t = 0;

        while(t<T){
            int N = Integer.parseInt(buffer.readLine());
            int cnt = 0;
            int[] arr = new int[N];
            String[] input= buffer.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] =Integer.parseInt(input[i]);
            }
            input= buffer.readLine().split(" ");
            int[] hat = new int[N];
            for (int i = 0; i < N; i++) {
                hat[i] =Integer.parseInt(input[i]);
            }
            Arrays.sort(arr);
            Arrays.sort(hat);
            boolean[] use = new boolean[N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j< N; j++) {
                    int num = hat[j];
                    int max = num+3;
                    int min = num-3;
                    if( min <=0) min = 1;
                    if(!use[j] && arr[i]>=min && arr[i]<max){
                        use[j] = true;
                        cnt++;
                        break;
                    }
                }
            }


            System.out.println("#" + (t+1) + " " + cnt );
            t++;
        }
    }
}
