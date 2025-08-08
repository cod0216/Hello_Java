package TIL;

/*
 * 1. 순열/조합/부분집합 개념 및 예시를 들어 설명하세요.
 *	(1) 순열
 *	- 개념: 서로 다른 n 개의 원소를 순서를 고려하여 나열하는 모든 경우의 수
 *	- 예시: 1 2 3 을 통해 만들 수 있는 것
 *          1 2 3, 1 3 2, 2 1 3, 2 3 1, 3 1 2, 3 2 1
 *
 *	(2) 조합
 *	- 개념: 서로 다른 n개의 원소 중에서 순서를 고려하지 않고 r개를 선택하는 모든 경우의 수
 *	- 예시: 1 2 3에서 2개를 뽑는 조합
 *          1 2, 1 3, 2 3
 *
 * 순열과 조합의 차이 ---> 각 자릿수 순서를 고려 하느냐 안하느냐
 *
 *	(3) 부분집합
 *	- 개념: 주어진 집합에서 원소를 선택하거나 선택하지 않는 모든 경우를 나열한 것
 *	- 예시: (1, 2, 3)의 부분 집합
 *          (), 1, 2, 3, 1 2, 1 3, 2 3, 1 2 3
 *
 * 2. 순열/조합/부분집합을 이용하여 아래의 코드를 구현하세요.
 *
 */
public class E01_PerCombiTest {
    static int[] num= {1,2,3};   // num={1,2,3,4}
    static int N=2;              // N=2, N=3
    static int sCount=0;

    //--------------------------------------------------------------------------------------
    private static void makePermutation(int toSelect,int[] selected, boolean[] visited) {
        if(toSelect == N){
            System.out.print("[ ");
            for (int i = 0; i < N; i++) {
                System.out.print(selected[i]+ " ");
            }
            System.out.print("]");
            System.out.println();
            return;
        }

        for (int i = 1; i <= num.length; i++) {
            if(visited[i-1]) continue;
            visited[i-1] = true;
            selected[toSelect] = i;
            makePermutation(toSelect+1, selected, visited);
            visited[i-1] = false;
        }
    }

    //--------------------------------------------------------------------------------------
    private static void makeCombination(int toSelect, int[] selected, int startIdx) {
        if(toSelect == N) {
            System.out.print("[ ");
            for (int i = 0; i < N; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.print("]");
            System.out.println();
            return;
        }

        for(int i = startIdx; i< num.length; i++){
            selected[toSelect] = num[i];
            makeCombination(toSelect+1, selected, i+1);
        }


    }

    //--------------------------------------------------------------------------------------
    private static void powerSet(int cnt, boolean[] isSelected) {
        if(cnt == num.length){
            System.out.print("[ ");
            for (int i = 0; i < num.length; i++) {
                if(isSelected[i]) System.out.print(num[i]+ " ");
            }
            System.out.print("]");
            sCount++;
            return;
        }
        isSelected[cnt] = true;
        powerSet(cnt+1, isSelected);
        isSelected[cnt] = false;
        powerSet(cnt+1, isSelected);
    }

    //--------------------------------------------------------------------------------------
    public static void main(String[] args) {
//		1. num에서 N개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
        System.out.println("-----순열-----");
        makePermutation(0, new int[N], new boolean[num.length]);

//		2. num에서 N개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
        System.out.println("-----조합-----");
        makeCombination(0, new int[N], 0);

//		3. num으로 구성할 수 있는 모든 부분집합을 출력하시오.
        System.out.println("-----부분집합-----");
        powerSet(0, new boolean[num.length]);
        System.out.println("\n총 경우의 수: " + sCount);
    }
}

/*
-----순열-----
[1, 2]
[1, 3]
[2, 1]
[2, 3]
[3, 1]
[3, 2]
-----조합-----
[1, 2]
[1, 3]
[2, 3]
-----부분집합-----
{1 2 3 },{1 2 },{1 3 },{1 },{2 3 },{2 },{3 },{},
총 경우의 수: 8
*/






