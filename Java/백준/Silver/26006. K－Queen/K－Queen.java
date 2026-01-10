
/*
나(킹)
체크 : 공격 받고 있으면 내가 움직여서 회피 가능한 상황
체크 메이트 : 공격 받고 있으면 내가 움직여도 피할수 없는 상황
스테일메이트 : 공격 받지 않지만 내가 움직이면 반드시 공격 받는 상황

체스판에 주어진 상황에서 3가지 경우 중 일치하는 상황을 출력

예상
    접근 방법 (단순한 탐색 구현)
    움직임이 없는 주어진 상황에서의 판단이므로 DFS로 맵에 표시
        킹이 표시에 있으면 체크 vs 체크 판단
    스테일메이트 판단 vs None 판단

시간 제한은 1초다. 맵의 크기는 1억*1억 (이중은 절대 안됨), k는 10만
    DFS 시간 초과가 나지 않을까 싶다. 
근데 생각해 보면 퀸은 가로 세로 움직이는데 그럼 1초를 넘길것으로 예상된다.
    킹의 위치로 탐색 조건(가지치기)을 줘서 탐색을 줄여야겠다.
    
    수학인가..? 그리디..?
*/

import java.io.*;
import java.util.*;

public class Main {

    static long N;
    static int K;

    static HashSet<Long> rowSet = new HashSet<>();
    static HashSet<Long> colSet = new HashSet<>();
    static HashSet<Long> diagDiffSet = new HashSet<>();
    static HashSet<Long> diagSumSet  = new HashSet<>();

    static HashSet<Long> occupied = new HashSet<>();

    static final int[] dr = {-1,-1,-1, 0,0, 1,1,1};
    static final int[] dc = {-1, 0, 1,-1,1,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long kr = Long.parseLong(st.nextToken());
        long kc = Long.parseLong(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            long r = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            rowSet.add(r);
            colSet.add(c);
            diagDiffSet.add(r - c);
            diagSumSet.add(r + c);

            occupied.add(pack(r, c));
        }

        boolean inCheck = isAttacked(kr, kc);

        boolean hasLegalMove = false;
        for (int i = 0; i < 8; i++) {
            long nr = kr + dr[i];
            long nc = kc + dc[i];

            if (!isIn(nr, nc)) continue;
            if (occupied.contains(pack(nr, nc))) continue; 

            if (!isAttacked(nr, nc)) {
                hasLegalMove = true;
                break;
            }
        }

        if (inCheck) {
            System.out.println(hasLegalMove ? "CHECK" : "CHECKMATE");
        } else {
            System.out.println(hasLegalMove ? "NONE" : "STALEMATE");
        }
    }

    static boolean isIn(long r, long c) {
        return (1L <= r && r <= N && 1L <= c && c <= N);
    }

    static boolean isAttacked(long r, long c) {
        if (rowSet.contains(r)) return true;
        if (colSet.contains(c)) return true;
        if (diagDiffSet.contains(r - c)) return true;
        if (diagSumSet.contains(r + c)) return true;
        return false;
    }

    static long pack(long r, long c) {
        return (r << 32) ^ c;
    }
}
