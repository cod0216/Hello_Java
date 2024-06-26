package collection.map.test;

import java.util.*;

public class DictionaryTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("==단어 입력 단계==");
        while(true){
            System.out.print("영어 단어를 입력하세요 (종료는 'q'): ");
            String str = scanner.nextLine();
            if(str.equals("q")){
                break;
            }
            System.out.print("한글 뜻을 입력하세요: ");
            String arr = scanner.nextLine();
            map.put(str,arr);
        }


        System.out.println("==단어 검색 단계==");
        while(true){
            System.out.print("찾을 영어 단어를 입력하세요 (종료는 'q'): ");
            String str = scanner.nextLine();
            if(str.equals("q")){
                break;
            }
            if(!map.containsKey(str)){
                System.out.println(str+"은(는) 사전에 없는 단어입니다.");
            }else System.out.println(str+"의 뜻 : " + map.get(str));
        }
    }
}
