package TIL;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.Collections;

public class J1448 {
    static int T;
    static Integer[] bag;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(buffer.readLine());
        int t = 0;
        bag = new Integer[T];

        while(T>t){
            bag[t] = Integer.parseInt(buffer.readLine());
            t++;
        }

        Arrays.sort(bag,Collections.reverseOrder());

        for (int i = 0; i < T-2; i++) {
            if(isAngle(bag[i],bag[i+1],bag[i+2])){
                System.out.println(bag[i]+bag[i+1]+bag[i+2]);
                return;
            }
        }

        System.out.println(-1);
    }

    public static boolean isAngle(int t, int c1, int c2){
        return t < c1+c2;
    }
}
