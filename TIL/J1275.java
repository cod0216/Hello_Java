package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1275 {
    static int n, q;
    static long[] tree;
    static long arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        q = Integer.parseInt(input[1]);

        arr = new long[n];


        input = buffer.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(input[i]);
        }

        tree = new long[4*n];
        build(1,0,n-1);

        for (int i = 0; i < q; i++) {
            input = buffer.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            System.out.println(sum(1, 0, n-1, x-1, y-1));

            int a = Integer.parseInt(input[2]);
            long b = Long.parseLong(input[3]);
            update(1, 0, n-1, a-1, b);
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
