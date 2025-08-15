package TIL;
import java.io.*;
import java.util.*;

public class S4013_2 {
    static LinkedList<Integer> t1, t2, t3, t4;
    public static void main(String args[]) throws IOException {
        BufferedReader buffer= new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T > t){
            int d = Integer.parseInt(buffer.readLine());

            t1 = readGear(buffer);
            t2 = readGear(buffer);
            t3 = readGear(buffer);
            t4 = readGear(buffer);


            for(int i=0; i < d; i++){
                String[] input = buffer.readLine().split(" ");
                int num = Integer.parseInt(input[0]);
                int spin = Integer.parseInt(input[1]);

                int[] dir = new int[5];
                dir[num] = spin;

                for(int k = num -1; k>= 1; k--){
                    if(!getGear(k).get(2).equals(getGear(k+1).get(6))) {
                        dir[k] = -dir[k+1];
                    } else break;
                }
                for(int k = num + 1; k <=4; k++){
                    if(!getGear(k-1).get(2).equals(getGear(k).get(6))){
                        dir[k] = -dir[k-1];
                    } else break;
                }
                for (int g = 0; g <= 4 ; g++) {
                    if(dir[g] != 0) spinFunc(getGear(g), dir[g]);
                }
            }
            int score=getScore();
            t++;
            System.out.println("#" + t + " " + score);
        }
    }

    public static int getScore(){
        return t1.get(0)+t2.get(0)*2+t3.get(0)*4+t4.get(0)*8;
    }

    public static LinkedList<Integer> readGear(BufferedReader buffer) throws IOException {
        LinkedList<Integer> gear = new LinkedList<>();
        String[] input = buffer.readLine().split(" ");
        for(int i = 0; i < 8; i++) {
            int value = Integer.parseInt(input[i]);
            gear.offer(value);
        }
        return gear;
    }

    public static LinkedList<Integer> getGear(int idx) {
        if(idx==1) return t1;
        if(idx==2) return t2;
        if(idx==3) return t3;
        return t4;
    }

    public static void spinFunc(LinkedList<Integer> gear, int dir) {
        if (dir == 1) {
            int value = gear.removeLast();
            gear.addFirst(value);
        } else {
            int value = gear.removeFirst();
            gear.addLast(value);
        }
    }
}
