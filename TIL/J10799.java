package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class J10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split("");

        LinkedList<Character> stack = new LinkedList<>();
        int size = input.length;
        int[] map = new int[size];
        int idx = 1;
        char before = '(';
        int ans = 0;
        stack.push(input[0].charAt(0));
        map[0] = 1;
        while(size>idx){
            char c = input[idx].charAt(0);

            if(c == '('){
                map[idx] = map[idx-1]+1;
                stack.push(c);
                before = '(';
            }
            else if (c == ')') {
                if(before=='('){
                    before = ')';
                    map[idx] = map[idx-1] -1;
                    stack.pop();
                    ans += map[idx];
                    map[idx-1] = 0;
                }else{
                    before = ')';
                    stack.pop();
                    ans +=1;
                    map[idx] = map[idx-1] -1;
                }

            }
            idx++;
        }
        System.out.println(ans);
    }
}
