package lambda.ex1;

import lambda.Procedure;

import java.util.Arrays;

public class M3MeasureTime {

    public static void main(String[] args) {

        Procedure p1 = new Procedure() {
            int N = 100;

            @Override
            public void run() {
                int sum = 0;
                for (int i = 1; i <= N; i++) {
                    sum += i;
                }
                System.out.print("[1부터 100까지 합] ");
                System.out.println("결과: " + sum);
            }
        };
        Procedure p2 = new Procedure() {
            int[] arr = new int[]{4, 3, 2, 1};

            @Override
            public void run() {
                System.out.println("원본 배열: " + Arrays.toString(arr));
                Arrays.sort(arr);
                System.out.println("배열 정렬: " + Arrays.toString(arr));
            }
        };
        measure(p1);
        measure(p2);
    }

    private static void measure(Procedure p) {
        long start = System.nanoTime();

        p.run();

        long end = System.nanoTime();
        System.out.println("실행 시간 : " + (end-start)+"ns");
    }
}
