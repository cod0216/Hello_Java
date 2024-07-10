package TIL;

import java.io.*;
import java.util.*;

public class J1377_1 {
    static LinkedList<int[]>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(buffer.readLine());

        A = new LinkedList[num];
        for(int i = 0; i < num; i++){
            A[i] = new LinkedList<>();
        }

        for(int i =0; i< num; i++){
            int value = Integer.parseInt(buffer.readLine());
            A[i].add(new int[]{value, i});
        }

        Arrays.sort(A, Comparator.comparingInt(a -> a.get(0)[0]));


        int result = 0;
        for(int i = 0; i < num; i++){
            int[] arr = A[i].get(0);
            int index = arr[1];

            if(index - i >result) result = index - i;

        }
        System.out.println(result+1);
/*
그리고 문제에서는 더 이상 정렬이 발생하지 않는 인덱스를 구하라고 되어 있는데,
앞쪽 칸으로 가장 많이 이동한 숫자를 찾아야 합니다.
2와 3이 있는데 숫자 상 빠른 2를 선택하고, 이에 대한 실제 인덱스는 3이므로 3이 정답이 됩니다.
그렇다면, 왜 앞쪽 칸으로 많이 이동한 숫자의 인덱스가 정답이 될까요?
그 이유는 앞쪽 칸으로 가장 많이 이동해야하는 횟수가 5번이라고 가정하면,
이 숫자가 이동할 동안 나머지 1, 3, 4번과 같은 낮은 횟수를 가진 요소가 이미 이동이 끝나있기 때문입니다.
여기서 질문이 한 가지 더 나올 수 있습니다.
"이동한 횟수 자체는 10이 더 많은데 왜 2를 고르는 것인가요?"와 같이 말이죠.
위에서 버블 소트를 실행한 과정을 보면 해답을 찾을 수 있습니다.
앞쪽으로 이동하는 요소는 1턴에 1칸이 최대인데, 뒤쪽으로 이동하는 요소는 1턴에 얼마든지 이동할 수 있습니다.
따라서, 같은 시간으로 기준으로 하였을 때,
앞쪽 칸만을 이동하는 숫자들만 비교해야하는 것입니다.
 */
    }
}
