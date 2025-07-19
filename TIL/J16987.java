package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Egg {
    public int s;
    public int w;

    public Egg(int s, int w){
        this.s = s;
        this.w = w;
    }

    public boolean isBroken(){
        return this.s <= 0;
    }
}

public class J16987 {
    static public int N;
    static Egg[] eggs;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
             String[] input = buffer.readLine().split(" ");

             int s = Integer.parseInt(input[0]);
             int w = Integer.parseInt(input[1]);

             eggs[i] = new Egg(s,w);
        }
        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int now){
        if(now == N ) {
            int brokenCount = 0;
            for (Egg egg : eggs) {
                if(egg.isBroken()) brokenCount++;
            }
            max = Math.max(max, brokenCount);
            return;
        }

        if(eggs[now].isBroken()){
            dfs(now+1);
            return;
        }

        boolean hit = false;
        for(int i = 0; i< N; i++) {
            if(i == now || eggs[i].isBroken()) continue;

            eggs[now].s -= eggs[i].w;
            eggs[i].s -= eggs[now].w;

            hit = true;
            dfs(now + 1);

            eggs[now].s += eggs[i].w;
            eggs[i].s += eggs[now].w;
        }

        if(!hit) {
            dfs(now + 1);
        }

    }
}
