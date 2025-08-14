package TIL;
import java.io.*;
import java.util.*;

public class S4013_3 {
    static LinkedList<Integer> t1, t2, t3, t4;
    public static void main(String args[]) throws IOException {
        BufferedReader buffer= new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T > t){
            int d = Integer.parseInt(buffer.readLine());

            t1 = new LinkedList<>();
            t2 = new LinkedList<>();
            t3 = new LinkedList<>();
            t4 = new LinkedList<>();
            String[] input;

            input = buffer.readLine().split(" ");
            for(int i = 0; i < 8; i++) {
                int value = Integer.parseInt(input[i]);
                t1.offer(value);
            }

            input = buffer.readLine().split(" ");
            for(int i = 0; i < 8; i++) {
                int value = Integer.parseInt(input[i]);
                t2.offer(value);
            }

            input = buffer.readLine().split(" ");
            for(int i = 0; i < 8; i++) {
                int value = Integer.parseInt(input[i]);
                t3.offer(value);
            }

            input = buffer.readLine().split(" ");
            for(int i = 0; i < 8; i++) {
                int value = Integer.parseInt(input[i]);
                t4.offer(value);
            }

            for(int i=0; i < d; i++){
                input = buffer.readLine().split(" ");
                int num = Integer.parseInt(input[0]);
                int spin = Integer.parseInt(input[1]);

                spinFunc(num,spin);
                if(t1.get(2) == t2.get(6) && t2.get(2) == t3.get(6) && t3.get(2) == t4.get(6))continue;
                secondsSpin(num, spin);
            }
            int score=getScore();
            t++;
            System.out.println("#" + t + " " + score);
        }
    }

    public static int getScore(){
        return t1.get(0)+t2.get(0)*2+t3.get(0)*4+t4.get(0)*8;
    }
    public static boolean checkSpin(int n1, int n2){
        if(n1 == 1) {
            if(t1.get(2) == t2.get(6)) return true;
            return false;
        } else if(n1 == 4){
            if(t3.get(2) == t4.get(6)) return true;
            return false;
        } else if(n1 == 2){
            if(n2== 1){
                if(t1.get(2) == t2.get(6)) return true;
                return false;
            } else if(n2==3){
                if(t2.get(2) == t3.get(6)) return true;
                return false;
            }
        } else if(n1 == 3){
            if(n2 == 2){
                if(t2.get(2) == t3.get(6)) return true;
                return false;
            }else if (n2==4){
                if(t3.get(2) == t4.get(6)) return true;
                return false;
            }
        }
        return false;
    }

    public static void secondsSpin(int num, int spin){

        if(num ==1){
            if(t1.get(2) != t2.get(6)) {
                if(spin>0){
                    if(checkSpin(num,2))return;
                    spinFunc(2,-1);
                    // spinFunc(2,-1);
                } else{
                    if(checkSpin(num,2))return;
                    spinFunc(2,1);
                    // spinFunc(2,1);
                }
            } else if(t2.get(2) != t3.get(6)) {
                if(spin>0){
                    if(checkSpin(2,3))return;
                    spinFunc(2,1);
                    // spinFunc(2,1);
                } else{
                    if(checkSpin(2,3))return;
                    spinFunc(2,-1);
                    // spinFunc(2,-1);
                }
            } else if(t3.get(2) != t4.get(6)) {
                if(spin>0){
                    if(checkSpin(3,4))return;
                    spinFunc(4,-1);
                    // spinFunc(4,-1);
                } else{
                    if(checkSpin(3,4))return;
                    spinFunc(4,1);
                    // spinFunc(4,1);
                }
            }
        } else if(num == 2){
            if(t2.get(2) != t3.get(6)) {
                if(spin>0){
                    if(checkSpin(num,3))return;
                    spinFunc(3,-1);
                    // spinFunc(3,-1);
                } else{
                    if(checkSpin(num,3))return;
                    spinFunc(3,1);
                    // spinFunc(3,1);
                }
            } else if(t2.get(6) != t1.get(2)) {
                if(spin>0){
                    if(checkSpin(num,1))return;
                    spinFunc(1,-1);
                    // spinFunc(1,-1);
                } else{
                    if(checkSpin(num,1))return;
                    spinFunc(1,1);
                    // spinFunc(1,1);
                }
            } else if(t4.get(6) != t3.get(2)) {
                if(spin>0){
                    if(checkSpin(3,4))return;
                    spinFunc(4,1);
                    // spinFunc(4,1);
                } else{
                    if(checkSpin(3,4))return;
                    spinFunc(4,-1);
                    // spinFunc(4,-1);
                }
            }
        } else if(num == 3){
            if(t3.get(2) != t4.get(6)) {
                if(spin>0){
                    if(checkSpin(num,4))return;
                    spinFunc(4,-1);
                    // spinFunc(4,-1);
                } else{
                    if(checkSpin(num,4))return;
                    spinFunc(4,1);
                    // spinFunc(4,1);
                }
            } else if(t3.get(6) != t2.get(2)) {
                if(spin>0){
                    if(checkSpin(num,2))return;
                    spinFunc(2,-1);
                    // spinFunc(2,-1);
                } else{
                    if(checkSpin(num,2))return;
                    spinFunc(2,1);
                    // spinFunc(2,1);
                }
            } else if(t2.get(6) != t1.get(2)) {
                if(spin>0){
                    if(checkSpin(2,1))return;
                    spinFunc(1,1);
                    // spinFunc(1,1);
                } else{
                    if(checkSpin(2,1))return;
                    spinFunc(1,-1);
                    // spinFunc(1,-1);
                }
            }
        }  else {
            if(t3.get(2) != t4.get(6)) {
                if(spin>0){
                    if(checkSpin(num,3))return;
                    spinFunc(3,-1);
                    // spinFunc(3,-1);
                } else{
                    if(checkSpin(num,3))return;
                    spinFunc(3,1);
                    // spinFunc(3,1);
                }
            } else if(t3.get(6) != t2.get(2)) {
                if(spin>0){
                    if(checkSpin(3,2))return;
                    spinFunc(2,1);
                    // spinFunc(2,1);
                } else{
                    if(checkSpin(3,2))return;
                    spinFunc(2,1);
                    // spinFunc(2,1);
                }
            } else if(t2.get(6) != t1.get(2)) {
                if(spin>0){
                    if(checkSpin(2,1))return;
                    spinFunc(1,-1);
                    // spinFunc(1,-1);
                } else{
                    if(checkSpin(2,1))return;
                    spinFunc(1,1);
                    // spinFunc(1,1);
                }
            }
        }

    }
    public static void spinFunc(int num, int spin){
        if(num == 1){
            if(spin>0){
                int value = t1.poll();
                t1.offer(value);
            }else {
                int value = t1.pop();
                t1.addLast(value);
            }
        } else if(num == 2){
            if(spin>0){
                int value = t2.poll();
                t2.offer(value);
            }else {
                int value = t2.pop();
                t2.addLast(value);
            }
        } else if(num == 3){
            if(spin>0){
                int value = t3.poll();
                t3.offer(value);
            }else {
                int value = t3.pop();
                t3.addLast(value);
            }
        } else if(num == 4){
            if(spin>0){
                int value = t4.poll();
                t4.offer(value);
            }else {
                int value = t4.pop();
                t4.addLast(value);
            }
        }

    }
}
