package exception.ex3;

import exception.ex3.NetworkClientExceptionV3;
import exception.ex3.NetworkServiceV3_1;

import java.util.Scanner;

public class MainV3 {
    public static void main(String[] args) {
//        NetworkServiceV1_1 networkService = new NetworkServiceV1_1();
//        NetworkServiceV1_2 networkService = new NetworkServiceV1_2();
//        NetworkServiceV1_3 networkService = new NetworkServiceV1_3();
//        NetworkServiceV2_1 networkService = new NetworkServiceV2_1();
//        NetworkServiceV2_2 networkService = new NetworkServiceV2_2();
//        NetworkServiceV2_3 networkService = new NetworkServiceV2_3();
//        NetworkServiceV2_4 networkService = new NetworkServiceV2_4();
//        NetworkServiceV2_5 networkService = new NetworkServiceV2_5();
//        NetworkServiceV3_1 networkService = new NetworkServiceV3_1();
//        NetworkServiceV3_2 networkService = new NetworkServiceV3_2();
        NetworkServiceV3_0 networkService = new NetworkServiceV3_0();

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("전송할 문자 : ");
            String input = scanner.nextLine();
            if(input.equals("exit")){
                break;
            }
            networkService.sendMessage(input);
            System.out.println();
        }
        System.out.println("프로그램을 정상 종료 합니다.");
    }
}
