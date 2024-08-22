package TIL;


import java.io.*;
import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void move(int d){
        switch (d){
            case 1: y--; break;
            case 2: x++; break;
            case 3: y++; break;
            case 4: x--; break;
        }
    }
}

class BC{
    Point point;
    int C, P;

    public BC(Point point, int C, int P){
        this.point = point;
        this.C = C;
        this.P = P;
    }
}

public class S5644 {
    static int M, A, res;
    static int[] dirA, dirB;
    static BC[] BCs;

    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter outer = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(buffer.readLine());
        int t = 0;
        while(T > t){
            String[] input = buffer.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            A = Integer.parseInt(input[1]);

            BCs = new BC[A];
            res = 0;

            dirA = new int[M];
            input = buffer.readLine().split(" ");
            for(int i = 0; i < M; i++){
                dirA[i] = Integer.parseInt(input[i]);
            }

            dirB = new int[M];
            input = buffer.readLine().split(" ");
            for(int i = 0; i < M; i++){
                dirB[i] = Integer.parseInt(input[i]);
            }

            for(int i = 0; i< A; i++){
                input = buffer.readLine().split(" ");
                BCs[i] = new BC(new Point(Integer.parseInt(input[0]),Integer.parseInt(input[1])), Integer.parseInt(input[2]), Integer.parseInt(input[3]));
            }

            go();
            t++;
            System.out.println("#"+t+" "+ res);
        }
    }

    public static void go(){
        Point userA = new Point(1, 1);
        Point userB = new Point(10, 10);

        charge(userA, userB);

        for(int i = 0 ; i< M; i++){
            userA.move(dirA[i]);
            userB.move(dirB[i]);
            charge(userA, userB);
        }
    }

    private static void charge(Point userA, Point userB){
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        for(int i = 0; i < A; i++){
            if(BCs[i].C >= (Math.abs(BCs[i].point.x - userA.x)) + Math.abs(BCs[i].point.y - userA.y)) {
                listA.add(i);
            }
            if(BCs[i].C >= (Math.abs(BCs[i].point.x - userB.x)) + Math.abs(BCs[i].point.y - userB.y)){
                listB.add(i);
            }
        }

        int max = 0, temp = 0;

        if(listA.size() > 0 && listB.size() >0){
            for(int i : listA){
                for(int j : listB){
                    temp = 0;
                    if(i == j) {
                        temp = BCs[i].P;
                    } else {
                        temp += BCs[i].P;
                        temp += BCs[j].P;
                    }
                    max = Math.max(max,temp);
                }
            }
        } else if (listA.size() > 0) {
            for(int i : listA) {
                if(max < BCs[i].P) max = BCs[i].P;
            }
        } else if( listB.size() > 0){
            for(int i :listB){
                if(max < BCs[i].P) max = BCs[i].P;
            }
        }
        res += max;
    }
}
