package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class J10703 {
    static int r, c;
    static ArrayList<Integer> diff= new ArrayList<>();
    static char  map[][];
    static LinkedList<Character> stack = new LinkedList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input= buffer.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        map = new char[r][c];

        for(int i = 0; i < r; i++){
            input= buffer.readLine().split("");
            for(int j = 0 ; j < c; j++){
                map[i][j]= input[j].charAt(0);
            }
        }

        /*
        X는 좌표 가장 큰수
        #는 좌표 가장 작은수

        두 차가 가장 작은값 -> 옮기는 칸
        그 칸만큼 내리기
        */

        find();
        int fall = diffMin();
//        System.out.println("fall = " + fall);
        // min만큼 중력 구현
        gravity(fall);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< r; i++){
            for(int j = 0; j< c; j++) {
                sb.append(map[i][j]);
            }
            if(i != r-1)sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void gravity(int fall){

        for(int i = 0; i<c; i++){
            int maxX = -1;
            for(int j = 0; j<r; j++){
                if(map[j][i] == 'X'){
                    stack.push(map[j][i]);
                    maxX = Math.max(maxX,j);
                }
            }
//            System.out.println("maxX = " + maxX);
            if(maxX == -1) continue;

            int key= maxX+fall;
            while(!stack.isEmpty()){
//                System.out.println("key : "+key);
                map[key--][i] = stack.pop();
            }
            while (key >= 0){
                map[key--][i] ='.';
            }
        }
    }

    private static int diffMin() {
        int min = Integer.MAX_VALUE;
        for(int n : diff){
            if(n>0) min = Math.min(min,n);
        }
        return min;
    }

    public static void find(){

        for(int j = 0; j < c; j++){
            int maxX = -1;
            int minD = r;
            for(int i = 0; i < r; i++){
                char c = map[i][j];
                if(c == 'X'){
                    maxX = Math.max(maxX,i);
                }else if(c == '#'){
                    minD = Math.min(minD,i);
                }
            }


            if (maxX != -1 && minD != Integer.MAX_VALUE) {
                diff.add(minD - maxX - 1);
            } else {
                diff.add(r - maxX-1);
            }
//            int res = Math.abs(minD-maxX);
//            System.out.println("res = " + res);
//            diff.add(res);
        }

//        int res = Math.abs(minD-maxX);
//        System.out.println("res = " + res);
//        diff.add(res);
    }
}
