package collection.list.test.ex1;

import java.util.*;

public class ListEx2 {
    public static void main(String[] args) {
        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        LinkedList<Integer> list = new LinkedList<>();

        while(num != 0){
            list.add(num);
            num = scanner.nextInt();
        }

        System.out.println("출력");
        for(int i =0; i< list.size(); i++){
            if(i == list.size()-1)
                System.out.print(list.get(i));
            else System.out.print(list.get(i) + ", ");
        }
    }
}
