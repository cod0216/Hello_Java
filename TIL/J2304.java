package TIL;

import java.io.*;
import java.util.*;

public class J2304 {

    static int num;
    static ArrayList<int[]>[] list;
    static int value = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(buffer.readLine());
        num+=2;

        list = new ArrayList[num];

        for(int i =0; i< num; i++){
            list[i] = new ArrayList<>();
        }

        for(int i =1; i< num-1; i++){
            String[] input = buffer.readLine().split(" ");
            int index= Integer.parseInt(input[0]);
            int height= Integer.parseInt(input[1]);

            list[i].add(new int[]{index, height});
        }
        list[0].add(new int[]{0,0});
        list[num-1].add(new int[]{1001,0});

        Arrays.sort(list, Comparator.comparingInt(o->o.get(0)[0]));

        int index = up(0);

        down(index);

        System.out.println(value);
    }

    public static int up(int start){
        int beforeWeight = list[start].get(0)[0];
        int max = list[start].get(0)[1];
        int index = start;
        for(int i = start; i<num; i++){
            if(max<=list[i].get(0)[1]){

                int weight = list[i].get(0)[0] - beforeWeight;
                value += max * weight;
                max = list[i].get(0)[1];
                beforeWeight=list[i].get(0)[0];

                index = i;
            }
        }
        value += max;
        return index;
    }

    public static void down(int start) {
        int beforeWeight = list[num-1].get(0)[0];
        int max = list[num-1].get(0)[1];
        for(int i = num-1; i>=start; i--){
            if(max<=list[i].get(0)[1]){

                int weight = beforeWeight - list[i].get(0)[0];
                value += max * weight;
                max = list[i].get(0)[1];
                beforeWeight=list[i].get(0)[0];
            }
        }
    }
}
