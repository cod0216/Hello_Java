package TIL;
import java.io.*;

public class J2042 {
    static int n, m, k;
    static long[] tree;
    static long arr[];
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        arr = new long[n+1];
        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(buffer.readLine());
        }

        tree = new long[4*n]; // 4배로 설정
        build(1, 0, n-1);

        for (int i = 0; i < m+k; i++) {
            input = buffer.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            long c = Long.parseLong(input[2]);

            if(a==1) {
                update(1, 0, n-1, b-1, c);
            } else {
                System.out.println(sum(1, 0, n-1, b-1, (int)c-1));
            }
        }
    }

    static long build(int node, int s, int e){
        if(s == e) {
            return tree[node] = arr[s];
        }

        int mid = (s + e) /2;
        return tree[node] = build(node*2, s, mid) + build(node*2+1, mid+1, e);
    }

    static void update(int node, int s, int e, int index, long v){
        if(s == e){
            tree[node] = v;
            return;
        }
        int mid = (s+e)/ 2;
        if(index <= mid){
            update(node*2, s, mid, index, v);
        }
        else {
            update(node*2+1, mid+1, e, index, v);
        }
        tree[node] = tree[node*2] + tree[node*2+1];
    }

    static long sum (int node, int s, int e, int l, int r) {
        if(r < s || e < l){
            return 0;
        }
        if(l <= s && e <= r) {
            return tree[node];
        }
        int mid = (s + e)/2;
        return sum(node*2, s, mid, l, r) + sum(node*2+1, mid+1, e, l, r);
    }
}



/*
루트 노드는 배열의 1번 인덱스에 저장됩니다.
왼쪽 자식 노드는 현재 인덱스 * 2에 저장됩니다.
오른쪽 자식 노드는 현재 인덱스 * 2 + 1에 저장됩니다.
부모 노드는 현재 인덱스 / 2에 저장됩니다. (여기서 /는 정수 나눗셈을 의미해요.)
 */