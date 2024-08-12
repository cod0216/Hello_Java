package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S4008 {
    static int max;
    static int min;
    static int result;
    static int[] operator;
    static int[] numArr;
    static int n;
    static ArrayList<Integer> arrayList;


    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;
        while(T > t){

            n = Integer.parseInt(buffer.readLine());

            max = -100000000;
            min = 100000000;

            operator= new int[4];
             numArr = new int[n];


            String[] input= buffer.readLine().split(" ");

            for(int i = 0; i < 4; i++){
                operator[i] = Integer.parseInt(input[i]);
            }

            input= buffer.readLine().split(" ");
            for(int i = 0; i< n; i++){
                numArr[i] = Integer.parseInt((input[i]));
            }


            arrayList =  new ArrayList<>();

            for(int i = 0; i < 4; i++){
                DFS(0);



            }

            result = max - min;

            t++;
            System.out.println("#" + t + " " + result);
        }

    }
            public static int solve(){
                int result =  numArr[0];
                for(int i = 0; i <arrayList.size(); i++){
                    switch (arrayList.get(i)){
                        case 0 :
                            result += numArr[i+1];
                            break;
                        case 1 :
                            result -= numArr[i+1];
                            break;
                        case 2 :
                            result *= numArr[i+1];
                            break;
                        case 3 :
                            result /= numArr[i+1];
                            break;
                    }
                }
                return result;

            }
            public static void DFS(int index){
                if(index == n-1){
                    int value = solve();
                    if(max < value){
                        max = value;
                    }
                    else if( min > value){
                        min = value;
                    }
                }

                for(int i = 0 ; i < 4; i++){
                    if(operator[i]>0){
                        arrayList.add(0,i);
                        operator[i] -= 1;
                        DFS(index+1);
                        operator[i] +=1;
                        arrayList.remove(0);
                    }
                }

            }
}
