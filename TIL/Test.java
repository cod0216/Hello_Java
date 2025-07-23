package TIL;
import java.util.*;
public class Test {
    public static void main(String[] args) {
        int result = solution(5,12);
        System.out.println("result = " + result);

    }
    static public int solution(int N, int number) {
        HashMap<Integer, HashSet<Integer>> box = new HashMap<>();

        for (int i = 1; i <= 8 ; i++) {
            box.put(i, new HashSet<Integer>());
        }

        box.get(1).add(N);
        if(isCheck(N,number)) return 1;

        for(int i = 2; i<=8; i++){
            HashSet<Integer> nums = box.get(i);

            for(int j =1; j<i; j++){
                HashSet<Integer> a = box.get(j);
                HashSet<Integer> b = box.get(i-j);
                for(int x: a){
                    for(int y: b){
                        nums.add(x+y);
                        nums.add(x-y);
                        nums.add(x*y);
                        if(x!= 0 && y!= 0) nums.add(x/y);
                    }
                }
                nums.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }
            if(nums.contains(number)) return i;
        }

        return -1;
    }

    public static boolean isCheck(int N, int v){
        if(N == v) return true;
        return false;
    }

}
