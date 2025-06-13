package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class J20166 {
    static int N, M, K;
    static char[][] map;

    static ArrayList<String> god = new ArrayList<>();

    static Map<String, Integer> trie = new HashMap<>();

    static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}, {1,-1}, {-1,1}, {1,1}, {-1,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        map = new char[N][M];

        for(int i = 0 ; i < N; i++ ){
            input = buffer.readLine().split("");
            for(int j = 0 ; j < M; j++ ){
                map[i][j] = input[j].toCharArray()[0];
            }
        }

        for(int i = 0 ; i < K; i++ ) {
            god.add(buffer.readLine());
        }

        print();
    }

    static public void record(int x, int y, int len, String word){
        if(trie.containsKey(word)){
            trie.put(word, trie.get(word) + 1);
        } else{
            trie.put(word, 1);
        }

        if(len == 5) return;

        for(int i = 0; i < 8; i++){
            int dx = (x + dir[i][0]) % N;
            int dy = (y + dir[i][1]) % M;

            if(dx < 0) dx += N;
            if(dy < 0) dy += M;

            record(dx, dy, len +1, word + map[dx][dy]);
        }
    }
    static public void print(){
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < M; j++){
                record(i,j,1,map[i][j] + "");
            }
        }


        for(int i = 0 ; i < god.size();i++){
            System.out.println(trie.getOrDefault(god.get(i),0));
        }
    }
}
