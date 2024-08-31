package TIL;

import java.io.*;
import java.util.*;

/*
 * 섬 갯수
 * 각 섬의 x좌표
 * 각 섬의 y좌표
 * 환경 부담금 (double)
 *
 * 일단 작성해보고 생각해보기
 *
 * (x,y) 하나의 노드
 *  (x,y)-가중치-(x,y)
 *        (E-L*L)
 */


class Edge implements Comparable<Edge>{
    public int from;
    public int end;
    public double wight;

    public Edge(int from, int end, double wight) {
        this.from = from;
        this.end = end;
        this.wight = wight;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.wight < o.wight)
            return -1;
        else if (this.wight == o.wight) return 0;
        else return 1;
    }
}// 시작 섬, 끝 섬, 길이 저장용 클래스



public class S1251 {
    static double E; // 환경 부담금
    static long[] arrX; // x좌표 저장
    static long[] arrY; // y좌표 저장
    static long[] arr; // 유니온용 배열
    static ArrayList<Edge> list;

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T>t) {

            int n = Integer.parseInt(buffer.readLine());


            arrX = new long[n];
            arrY = new long[n];

            String[] input = buffer.readLine().split(" ");
            for(int i = 0; i <n; i++){
                arrX[i] = Long.parseLong(input[i]);
            }

            input = buffer.readLine().split(" ");
            for(int i = 0; i <n; i++){
                arrY[i] = Long.parseLong(input[i]);
            }

            E = Double.parseDouble(buffer.readLine());

            //입력 -완-

            arr = new long[n];
            for(int i = 0 ; i < n; i++){
                arr[i] = i;
            }

            list = new ArrayList<>();
            for(int i = 0 ; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    long dis = (arrX[i]-arrX[j])*(arrX[i]-arrX[j]) + (arrY[i]-arrY[j]) * (arrY[i]-arrY[j]);
                    list.add(new Edge(i,j,dis));
                }
            }

            // 유니온 배열 및 리스트 초기화 및 값 할당

            Collections.sort(list);

            // 길이(가중치) 기준 자연순서 정렬

            int cnt = 0;
            double w = 0;
            for(Edge e : list){
                long start =e.from;
                long end = e.end;

                long min = Math.min(start, end);
                long max = Math.max(start, end);


                long a = find((int)min);
                long b = find((int)max);

                if(a!=b){
                    union((int)a,(int)b);
                    w += e.wight;
                    cnt++;
                }
//                else {
//                    if(cnt == n-1) break;
//                }
            } // MST

            t++;
            System.out.println("#" + t + " " + Math.round(w*E));
        }
    }

    public static long find(int v){
        if(arr[v] != v){
            return arr[v] = find((int)arr[v]);
        }
        return arr[v];
    }
    public static void union(int a, int b){
        if(arr[a] != arr[b]) {
            arr[b] = find((int)arr[a]);
        }
    }
}
