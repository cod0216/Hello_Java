package TIL;

import java.io.*;


public class J1717 {
    static int[] Node;
    static boolean check;

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");

        int node = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        Node = new int[node+1];
        for(int i = 0; i <= node; i++){
            Node[i] = i;
        }

        while(n>0){
            input = bufferedReader.readLine().split(" ");

            int value1 = Integer.parseInt(input[1]);
            int value2 = Integer.parseInt(input[2]);
            if(value1 < value2) {
                int temp = value1;
                value1 = value2;
                value2 = temp;
            }

            value1 = find(value1);
            value2 = find(value2);

            if(Integer.parseInt(input[0]) == 0){
               union(value1, value2);
            }
            if(Integer.parseInt(input[0]) == 1) {
                check(value1, value2);
                if(check){
                    System.out.println("YES");
                }
                else System.out.println("NO");
            }

            check = false;
            n--;
        }



    }

    private static void union(int value1, int value2){
        if(Node[value1] != Node[value2]){
            Node[value1] = Node[value2];
        }
    }
    private static void check(int value1, int value2){
        if(Node[value1] == Node[value2]){
            check = true;
        }
    }

    private static int find(int num){
        if(num == Node[num])
            return Node[num];
        else return  Node[num] = find(Node[Node[num]]);

    }
}
