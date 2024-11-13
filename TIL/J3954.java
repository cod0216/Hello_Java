//package TIL;
//
//import java.io.*;
//import java.util.*;
//
//
//public class J3954 {
//    static int index, comNum, inNum, now;
//    static String comArr[], inChar[];
//    static LinkedList<Integer> stackRight;
//    static LinkedList<Integer> stackLeft;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//
//        int T = Integer.parseInt(buffer.readLine());
//        int t = 0;
//
//        while(T > t) {
//           String[] input = buffer.readLine().split(" ");
//            stackRight = new LinkedList<>();
//            stackLeft = new LinkedList<>();
//
//            int index = Integer.parseInt(input[0]);
//            int comNum = Integer.parseInt(input[1]);
//            int inNum = Integer.parseInt(input[2]);
//
//            memory = new int[index];
//            comArr = new String[comNum];
//            inChar = new String[inNum];
//
//           input= buffer.readLine().split("");
//           for(int i= 0 ; i<input.length;i++) {
//                if(input[i].equals("[")){
//                    stackLeft.push(i);
//                }
//               if(input[i].equals("]")){
//                   stackRight.push(i);
//               }
//               comArr[i] = input[i]; // -> [ ] 인덱스 stack에 넣기
//           }
//           input = buffer.readLine().split("");
//           inChar = input.clone();
//
//
//
//            t++;
//        }
//    }
//
//    public static void commend(char c){
//        switch (c){
//            case '+':
//                now = (now+1)%256;
//                break;
//            case '-':
//                now -=1;
//                if(now ==-1) now = 255;
//                break;
//            case '<':
//                now -=1;
//                if(now ==-1) now = 255;
//                break;
//                break;
//            case '>':
//                now = (now+1)%256;
//                break;
//            case '[':
//                if(inChar[now] == "0"){
//                    now = stackRight.pop();
//                }
//                break;
//            case ']':
//                if(inChar[now] != "0"){
//                    now = stackLeft.pop();
//                }
//                break;
//            case '.':
//                inChar[now];
//                break;
//            case ',':
//
//                break;
//        }
//    }
//}
