//package TIL;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//
///*
//상자는 지면에서 평행하게 회전시킬 수 있다. 윗면은 언제나 천장을 바라보고 있는 상태여야 한다.
//상자 배열이 끝난 후, 서로 인접한 두 상자의 인접한 면에 적힌 수는 같아야 한다.
//다른 상자와 인접해 있지 않은 면에 적힌 수는 0이어야 한다.
//
// */
//public class J1721 {
//    static LinkedList<Integer>[] box;
//    public static void main(String args[]) throws IOException {
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(buffer.readLine());
//
//        int N = n*n;
//
//         box = new LinkedList[N+1];
//
//         for(int i = 0; i < N+1; i++){
//             box[i] = new LinkedList<>();
//         }
//
//        for(int i = 0; i < N+1; i++){
//            String[] input = buffer.readLine().split(" ");
//            int head = Integer.parseInt(input[0]);
//            box[head].add(Integer.parseInt(input[1]));
//            box[head].add(Integer.parseInt(input[2]));
//            box[head].add(Integer.parseInt(input[3]));
//            box[head].add(Integer.parseInt(input[4]));
//
////            findEdge();
//        }
//
//
//    }
//    public static void findEdge(LinkedList<Integer> b) {
////        if(b.get(0)){}
//        // 각 엣지 탐색해서 기록 하기
//    }
//}
