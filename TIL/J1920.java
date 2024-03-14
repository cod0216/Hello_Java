package TIL;

import java.util.*;


public class J1920 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int[] A = new int[num];
        for(int i = 0 ; i < num ; i++){
            A[i] = scanner.nextInt();
        }
        Arrays.sort(A);


        int n = scanner.nextInt();
        int[] B = new int[n];
        for(int i = 0 ; i < n; i++){
            int start = 0;
            int end = num-1;
            B[i] = scanner.nextInt();
            int find = 0;
            while(end>=start){
                int mid = (end+start)/2;

                if(A[mid] < B[i]){
                    start = mid+1;
                }
                else if(A[mid] > B[i]){
                    end = mid-1;
                }
                else if (A[mid] == B[i]) {
                    find =1;
                    break;
                }

            }
            if( find == 1 )
                System.out.println(1);
            else System.out.println(0);
        }

    }
}
