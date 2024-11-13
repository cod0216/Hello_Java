package TIL;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class S1824 {

    static char[][] map;
    static int memory, d, cnt, r, c, x, y;
    static boolean stop;
    static int[] dx = new int[]{-1, 0, 1, 0};//상, 좌, 하, 우
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(buffer.readLine());
        int t = 0;
        while(T>t){
            stop=false;
            d = 3;
            t++;
            cnt = 0;
            String[] input = buffer.readLine().split(" ");
            r = Integer.parseInt(input[0]);
            c = Integer.parseInt(input[1]);
            map = new char[r][c];

            for(int i = 0 ; i < r; i++){
                input = buffer.readLine().split("");
                for(int j = 0 ; j < c; j++){
                    map[i][j] = input[j].charAt(0);
                }
            } // input end

            x=0; y=0;
            while(true){
//                System.out.println("memory = " + memory);
                cnt++;
                if(!isIn(x,y)) {
                    System.out.println("#" + t + " " + "NO");
                    break;
                }
                search(map[x][y]);
                if(stop){
                    System.out.println("#" + t + " " + "YES");
                    break;
                }
                if(cnt>= 1000){
                    System.out.println("#" + t + " " + "NO");
                    break;
                }

                x +=dx[d]; y += dy[d];
            }

        }
    }
    public static boolean isIn(int x, int y){
        return x>=0 && y>= 0 && x< r && y<c;
    }
    public static void search(char c){
//        System.out.println(c);
        if(c == '<' || c == '>' || c == '^' || c == 'v'){
            if(c == '<') d = 1;
            else if (c == '>') d = 3;
            else if (c == '^') d= 0;
            else d= 2;
        }
        else if(c == '_' || c == '|'){
            if(c == '_'){
                if(memory == 0) d=3;
                else d=1;
            }
            else if (c == '|'){
                if(memory == 0) d=2;
                else d=0;
            }
        }else if(c == '@'){
            stop = true;
//            System.out.println("롸?");
        }else if(c == '?'){
            d=(d+1)%4;
            while(!isIn(x+dx[d],y+dy[d])){
                d=(d+1)%4;
            }
        } else if(c == '.'){

        }else if(c == '-' || c == '+'){
            if(c=='-'){
                memory--;
            }else if(c=='+'){
                memory++;
            }
            if (memory < 0){
                memory = 15;
            }else if(memory > 15){
                memory = 0;
            }
        }
        else{
            memory = (int)c - (int)'0';
        }

    }
}
