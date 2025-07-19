package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class J1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(buffer.readLine());
        String[] array = new String[N];

        for (int i = 0 ; i < N; i++){
             array[i] = buffer.readLine();
        }

        Arrays.sort(array,(a,b) -> b.length() - a.length());

        HashSet<String> set = new HashSet<>();
        for (String s1 : array) {
            if (set.size() == 0) {
                set.add(s1);
                continue;
            }

            boolean flag = true;
            for (String s2 : set) {
                if (s2.indexOf(s1) == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                set.add(s1);
            }
        }

        System.out.println(set.size());
    }
}
