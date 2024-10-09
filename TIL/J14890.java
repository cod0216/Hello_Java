//package TIL;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//import java.util.Queue;
//
//
//public class J14890 {
//
//    static int n, m, map[][];
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = buffer.readLine().split(" ");
//        n = Integer.parseInt(input[0]);
//        m = Integer.parseInt(input[1]);
//        LinkedList<Integer> queue = new LinkedList<>();
//        queue.offerFirst();
//        map = new int[n][n];
//        String[][] plans = new String[3][4];
//        int n = plans.length;
//        int d = pla;
//
//
//        for(int i = 0 ; i < n; i++){
//            input = buffer.readLine().split(" ");
//            for(int j = 0; j < n; j++){
//                map[i][j] = Integer.parseInt(input[j]);
//            }
//        } // 입력완료
//
//        int ans = 0;
//        for(int i = 0 ; i < n; i++){
//            if(colGo(i)) ans++;
//            if(rowGo(i)) ans++;
//        }
//
//        System.out.println(ans);
//    } // main end
//
//    public static boolean colGo(int now){
//        boolean[] incline = new boolean[n];
//        for(int i = 0; i < n-1; i++){
//            int height = map[now][i] - map[now][i+1];
//            if(Math.abs(height)>1) return false;
//
//            if(height == 1){
//                for(int j = 1 ; j <= m; j++){
//                    if(i+j>=n || incline[i+j]) return false;
//                    if(map[now][i]-1 != map[now][i+j]) return false;
//                    incline[i+j] = true;
//                }
//            }
//            else if(height == -1){
//                for(int j = 0 ; j < m; j++){
//                    if(i-j<0 || incline[i-j]) return false;
//                    if(map[now][i] != map[now][i-j]) return false;
//                    incline[i-j] = true;
//                }
//            }
//        } // outer for end
//
//        return true;
//    }
//    public static boolean rowGo(int now){
//        boolean[] incline = new boolean[n];
//        for(int i = 0; i < n-1; i++){
//            int height = map[i][now] - map[i+1][now];
//            if(Math.abs(height)>1) return false;
//
//            if(height == 1){
//                for(int j = 1 ; j <= m; j++){
//                    if(i+j>=n || incline[i+j] ) return false;
//                    if(map[i][now]-1 != map[i+j][now]) return false;
//                    incline[i+j] = true;
//                }
//            }
//            else if(height == -1){
//                for(int j = 0 ; j < m; j++){
//                    if(i-j<0 || incline[i-j]) return false;
//                    if(map[i][now] != map[i-j][now]) return false;
//                    incline[i-j] = true;
//                }
//            }
//        }// outer for end
//
//        return true;
//    }
//
//
//}
