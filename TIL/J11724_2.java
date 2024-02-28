package TIL;


import java.util.*;


public class J11724_2 {
    static ArrayList<Integer>[] arrayList;
    static boolean[] visited;// 초기값은 false로 초기화된다.
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();

        arrayList = new ArrayList[n + 1];
        visited = new boolean[n+1];
//        for(int i = 0 ; i < n+1; i++)
//        System.out.println("visited"+"["+i+"] = "+ visited[i]);

        for (int i = 1; i <= n; i++) {
            arrayList[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < e; i++) {
            int value_1 = scanner.nextInt();
            int value_2 = scanner.nextInt();

            arrayList[value_1].add(value_2);
            arrayList[value_2].add(value_1);
        }

        // 여기부터 다시 알아보기
        for(int i= 1; i<=n ; i++)
            if(!visited[i]) {
                count++;
                DFS(i);
            }
        System.out.println(count);
    }
    public static void DFS(int n) {
        if(visited[n])
            return;
        visited[n] = true;
// 여기가 이해가 안되는 거임

        for(int i = 0; i < arrayList[n].size(); i++){
            int node = arrayList[n].get(i);
            if (!visited[node])
                DFS(node);
        }

    }
}