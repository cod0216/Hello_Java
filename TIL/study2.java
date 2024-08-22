package TIL;

/*
 * 1. 순열/조합/부분집합 개념 및 예시를 들어 설명하세요.
 *	(1) 순열
 *	- 개념:
 *	- 예시:
 *
 *	(2) 조합
 *	- 개념:
 *	- 예시:
 *
 *	(3) 부분집합
 *	- 개념:
 *	- 예시:
 *
 * 2. 순열/조합/부분집합을 이용하여 아래의 코드를 구현하세요.
 *
 */
public class study2 {
    static int[] num= {1,2,3};   // num={1,2,3,4}
    static int N=3;              // N=2, N=3
    static int sCount=0;

    public static void main(String[] args) {
//		1. num에서 N개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
//		System.out.println("-----순열-----");
//		makePermutation(0, new int[N], new boolean[num.length]);

//		2. num에서 N개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
//        System.out.println("-----조합-----");
//        makeCombination(0, new int[N], 0);

//		3. num으로 구성할 수 있는 모든 부분집합을 출력하시오.
		System.out.println("-----부분집합-----");
		powerSet(0, new boolean[num.length]);
//		System.out.println("\n총 경우의 수: " + sCount);
    }

    //--------------------------------------------------------------------------------------
    private static void makePermutation(int toSelect,int[] selected, boolean[] visited) {

    }

    //--------------------------------------------------------------------------------------
    private static void makeCombination(int toSelect, int[] selected, int startIdx) {
        if(startIdx == num.length){
            for(int i = 0 ; i < selected.length; i++){
                System.out.print(selected[i]+" ");
            }

            System.out.println();
            return;
        }
        for(int i = 0 ; i < selected.length; i++){
            selected[toSelect]=num[i];
            makeCombination(toSelect+1, selected, i+1);
        }

        //for (int i = startIdx; i < num.length; i++) {
        //			selected[toSelect] = num[i];
        //			makeCombination(toSelect + 1, selected, i + 1);
        //		}


    }

    //--------------------------------------------------------------------------------------
    private static void powerSet(int cnt, boolean[] isSelected) {
        if(cnt == N){
            for(int i = 0; i < cnt; i++){
                if(isSelected[i]){
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }

        isSelected[cnt] = true;
        powerSet(cnt+1, isSelected);

        isSelected[cnt] = false;
        powerSet(cnt+1, isSelected);

    }

    //--------------------------------------------------------------------------------------
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






