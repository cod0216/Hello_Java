package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Car implements Comparable<Car>{
    int idx;
    long location;
    long fuel;

    public Car(int idx, long location, long fuel) {
        this.idx = idx;
        this.location = location;
        this.fuel = fuel;
    }

    @Override
    public int compareTo(Car o) {
        if(this.location < o.location) return -1;
        else if(this.location > o.location) return 1;
        else return 0;
    }
}

public class J25395 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        Car[] arr = new Car[n];

        String[] locates = buffer.readLine().split(" ");
        String[] moving = buffer.readLine().split(" ");

        LinkedList<Car> list = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        for (int i = 0; i < n; i++) {
            arr[i] = new Car(i+1, Integer.parseInt(locates[i]), Integer.parseInt(moving[i]));
        }

        list.add(arr[s-1]);
        visited[s] = true;

        Arrays.sort(arr);

        while(!list.isEmpty()) {
            Car cur = list.poll();
            long leftBound = cur.location - cur.fuel;
            long rightBound = cur.location + cur.fuel;

            int leftIdx = lowerBound(arr, leftBound);
            int rightIdx = upperBound(arr, rightBound);


            for (int i = leftIdx; i < rightIdx; i++) {
                if (visited[arr[i].idx]) {
                    list.add(arr[i]);
                    visited[arr[i].idx] = true;
                }
            }// 중앙에서 왼쪽
        }

        for(int i = 1; i< n+1; i++){
            if(visited[i]){
                System.out.print(i+" ");
            }
        }
    }

    public static int lowerBound(Car[] arr, long target){
        int left = 0, right = arr.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid].location < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static int upperBound(Car[] arr, long target){
        int left = 0, right = arr.length;
        while(left < right) {
            int mid = (left + right) / 2;
            if(arr[mid].location <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
