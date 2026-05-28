package TIL;

import java.util.*;

class P_1 {
    static class Car{
        public int weight;
        public int cost;

        public Car(int weight, int cost){
            this.weight = weight;
            this.cost = cost;
        }
    }

    public static void main(int[] args) {
        String[] cities = {};
        String[] roads = {};
        String[] cars = {};
        String[] customers = {} ;

        int cityCnt = cities.length;
        Map<String, Integer> cityIdx = new HashMap<>();

        for(int i = 0 ; i < cityCnt; i++){
            cityIdx.put(cities[i], i);
        }
        long[][] dist = new long[cityCnt][cityCnt];
        long INF = Long.MAX_VALUE/4;

        for(int i = 0; i < cityCnt; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for(String road : roads){
            String[] temp = road.split(" ");
            int a = cityIdx.get(temp[0]);
            int b = cityIdx.get(temp[1]);
            int c = Integer.parseInt(temp[2]);

            dist[a][b] = c;
            dist[b][a] = c;
        }
        for(int k = 0; k < cityCnt; k++){
            for(int i = 0; i < cityCnt; i++){
                for(int j = 0; j < cityCnt; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        ArrayList<Car>[] carList = new ArrayList[cityCnt];

        for(int i = 0 ; i < cityCnt; i++){
            carList[i] = new ArrayList<>();
        }
        for(String car : cars){
            String[] temp = car.split(" ");
            int city = cityIdx.get(temp[0]);
            int w = Integer.parseInt(temp[1]);
            int c = Integer.parseInt(temp[2]);

            carList[city].add(new Car(w, c));
        }

        for(int i = 0; i < cityCnt; i++){
            carList[i].sort(Comparator.comparingInt(c -> c.weight));
        }

        String[] answer = new String[customers.length];

        for(int i = 0; i < customers.length; i++){
            String[] customer = customers[i].split(" ");
            int s = cityIdx.get(customer[0]);
            int e = cityIdx.get(customer[1]);
            int w = Integer.parseInt(customer[2]);

            long minCost = Long.MAX_VALUE;
            String best = null;

            for(int c = 0 ; c < cityCnt; c++){
                Car car = findCar(carList[c], w);
                if(car == null) continue;

                if(dist[c][s] == INF || dist[s][e] == INF) continue;

                long distance = dist[c][s] + dist[s][e];
                long cost = distance * car.cost;

                if(cost < minCost || (cost == minCost && (best == null || cities[c].compareTo(best) < 0))){
                    minCost = cost;
                    best = cities[c];
                }
            }
            answer[i] = best;

        }
    }

    public static Car findCar(ArrayList<Car> cars, int w){
        int l = 0;
        int r = cars.size();

        while(l < r){
            int m = (l + r) / 2;
            if(cars.get(m).weight >= w){
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l == cars.size() ? null : cars.get(l);
    }
}

/*
    0 : 111101101101111
    1 : 110010010010111
    2 : 111001111100111
    3 : 111001111001111
    4 : 101101111001001
    5 : 111100111001111
    6 : 111100111101111
    7 : 111101001001001
    8 : 111101111101111
    9 : 111101111001111
*/
/*
class Solution {
    static String[] num = {
            "111101101101111",
            "110010010010111",
            "111001111100111",
            "111001111001111",
            "101101111001001",
            "111100111001111",
            "111100111101111",
            "111101001001001",
            "111101111101111",
            "111101111001111"

    };
    public String solution(String[] pixels) {
        int cnt = pixels[0].length()/3;
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < cnt; i++){
            StringBuilder cur = new StringBuilder();

            for(int r = 0; r < 5; r++){
                cur.append(pixels[r], i*3, i*3+3);
            }
            String t = cur.toString();

            for(int n = 0; n < 10; n++){
                if(num[n].equals(t)){
                    ans.append(n);
                }
            }
        }


        return ans.toString();
    }
}

class Solution {
    static int ans = 0;
    public int solution(int[] nums) {
        dfs(nums,0,0,0);
        return ans;
    }

    public static void dfs(int[] nums, int start, int depth, int sum){
        if(depth == 3) {
            if(isPrime(sum)) ans++;
            return;
        }

        for(int i = start; i < nums.length; i++) {
            dfs(nums, i+1, depth+1, sum + nums[i]);
        }
    }

    public static boolean isPrime(int num){
        if(num < 2) return false;

        for(int i = 2 ; i*i <= num; i++){
            if(num % i == 0) return false;
        }

        return true;
    }
}
*/
