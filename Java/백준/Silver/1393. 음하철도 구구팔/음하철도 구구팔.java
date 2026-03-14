import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int sx = Integer.parseInt(input[0]);
        int sy = Integer.parseInt(input[1]);
        
        input = buffer.readLine().split(" ");
        int cx = Integer.parseInt(input[0]);
        int cy = Integer.parseInt(input[1]);
        int dx = Integer.parseInt(input[2]);
        int dy = Integer.parseInt(input[3]);
        
        int gcd = gcd(Math.min(dx,dy),Math.max(dx,dy));
        
        dx /= gcd;
        dy /= gcd;

        int minDistance = (sx - cx) * (sx - cx) + (sy - cy) * (sy - cy);
        int[] result = new int[2];
        result[0] = cx;
        result[1] = cy;
        while(true){
            int nx = cx + dx;
            int ny = cy + dy;
            int distance = (sx - nx) * (sx - nx) + (sy - ny) * (sy - ny);
            if(distance >= minDistance){
                break;
            }
            minDistance = distance;
            result[0] = nx;
            result[1] = ny;
            cx = nx;
            cy = ny;
        }
        System.out.println(result[0] + " " + result[1]);
    }

    static int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(b%a, a);
    }
}