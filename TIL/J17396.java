//package TIL;
//
//import java.io.*;
//import java.util.*;
//
///*
//N 과 M 주어짐
//
//넥서스를 제외하면 시야있는곳 ㄴㄴ
//
//다익스트라 + 방문배열 시야
//pq 사용
// */
//class Node3 implements Comparable<Node3>{
//    int end;
//    int weight;
//
//    int compareTo(Node3 o){
//        return this.weight- o.weight;
//    }
//
//}
//
//public class J17396 {
//    static int n, m, distance[], visiable[];
//    static boolean visited[];
//    static ArrayList<int[]>[] list;
//    public static void main(String[] args) throws IOException {
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = buffer. readLine().split(" ");
//
//        n = Integer.parseInt(input[0]);
//        m = Integer.parseInt(input[1]);
//
//        list = new ArrayList[n];
//        visiable = new int[n];
//        distance = new int[n];
//        visited = new boolean[n];
//
//        Arrays.fill(distance,Integer.MAX_VALUE);
//
//
//    }
//
//    public static void dijkstra(){
//
//    }
//
//}
