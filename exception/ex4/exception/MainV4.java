package exception.ex4.exception;

import java.util.Scanner;

public class MainV4 {
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
//        NetworkServiceV3_0 networkService = new NetworkServiceV3_0();
        NetworkServiceV4 networkService = new NetworkServiceV4();

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("전송할 문자 : ");
            String input = scanner.nextLine();
            if(input.equals("exit")){
                break;
            }
            try {
                networkService.sendMessage(input);
            } catch (Exception e){
                exceptionHandler(e);
            }
            System.out.println();
        }
        System.out.println("프로그램을 정상 종료 합니다.");
    }

    private static void exceptionHandler(Exception e) {
        System.out.println("사용자 메시지 : 죄송합니다. 알 수 없는 문제가 발생했습니다.");
        System.out.println("==개발자용 디버깅 메시지==");

        e.printStackTrace(System.out);

        if(e instanceof SendExceptionV4 send){
            System.out.println("[전송 오류] 전송 데이터 : " + send.getSendData());
        }
    }
}
