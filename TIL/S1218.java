package TIL;

import java.io.*;
import java.util.*;

public class S1218 {
    static Deque<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        int t = 0;
        while(T>t) {
            int index = Integer.parseInt(buffer.readLine());
            stack = new ArrayDeque<>();
            String str = buffer.readLine();

            char[] arr = str.toCharArray();
            int value = 1;

            for (int i = 0; i < arr.length; i++) {
                char a = arr[i];
                if (a == '(' || a == '[' || a == '{' || a == '<') {
                    stack.push(a);
                } else {
                    if (!stack.isEmpty()) {
                        if (a == ')') {
                            if (stack.pop() != '(') {
                                value = 0;
                                break;
                            }
                        } else if (a == ']') {
                            if (stack.pop() != '[') {
                                value = 0;
                                break;
                            }
                        } else if (a == '}') {
                            if (stack.pop() != '{') {
                                value = 0;
                                break;
                            }
                        } else if (a == '>') {
                            if (stack.pop() != '<') {
                                value = 0;
                                break;
                            }
                        }
                    }
                    else{
                        value = 0;
                        break;
                    }

                }
            }
            t++;
            System.out.println("#" + t + " " + value);
        }
    }
}
