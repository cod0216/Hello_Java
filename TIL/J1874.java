package TIL;

import java.util.Scanner;
import java.util.Stack;

public class J1874 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int handle = 0;
        int num = scanner.nextInt();

        int[] numArray = new int[num];
        for (int i = 0; i < num; i++) {
            numArray[i] = scanner.nextInt();
        }
        StringBuffer stringBuffer = new StringBuffer();
        int value;
        while (handle != numArray.length) {
            if (!stack.empty()) {
                value = stack.peek();
            } else {
                stack.push(++count);
                stringBuffer.append("+\n");
                value = stack.peek();
            }

            if (numArray[handle] > value) {
                stack.push(++count);
                stringBuffer.append("+\n");
            } else if (numArray[handle] == value) {
                stack.pop();
                stringBuffer.append("-\n");
                handle++;
            } else if(numArray[handle] < value){
                break;
            }
        }
        if (handle != numArray.length) {
            System.out.println("NO");
            return;
        }
        System.out.println(stringBuffer.toString());


    }
}
