package array;

public class EnhancedFor1 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5};

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            System.out.print(number + " ");
        }
        //향상된 for문, for-each문
        System.out.println();
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();

        //for-each문을 사용할 수 없는 경우
        for(int i = 0; i < numbers.length; i++) {
            System.out.println("number" + i + "번의 결과는 : " + numbers[i]);
        }
    }
}
