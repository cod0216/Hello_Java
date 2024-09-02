package TIL;

import java.io.*;
import java.util.*;
/*
식당 도착 시 입구 줄 서서 대기

먼저 도착한 학생이 나중에 온 학생보다 식당 입구 앞쪽에서 대기
식사는 1인분
식사 1인분 완성 시 맨 앞에 대기 중인 학생 1명씩 들어와 식사
식사 시작한 학생은 항상 식사 맞친다.


식사가 n개 저장된 A가 주어진다.
A에 저장된 첫번째 정보부터 n번째 정보까지 순서대로 처리한다.
식당 입구에서 줄 서서 대기하는 수가 max인 경우 이때 식당 입구 맨 뒤 대기 중인
학생의 번호를 출력하자,

만약 최대의 경우가 여러번 이라면 맨 뒤에 줄 서 있는 학생의 번호가 가장 작은 경우를 출력

1. 학생 a가 식당에 도착시 입구 맨 뒤에서 줄 대기
2. 식사 1인분이 준비된 경우 입구 맨 앞에 학생1이 식사 시작
식사 1인분이 준비될 떄는 식당 입구에 대기 중인 학생이 항상 존대
줄을 서서 대기 여도 식사 준비가 안된 경우 식사를 못한다.



 */

public class J26042 {
    public static void main(String[] args) throws IOException {
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);

//        int N = Integer.parseInt(buffer.readLine());
        int N = scanner.nextInt();

//        String[] input = buffer.readLine().split(" ");
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        int student=0;

        for(int i = 0; i < N; i++){
//            input = buffer.readLine().split(" ");
//            int value = Integer.parseInt(input[0]);
            int value = scanner.nextInt();

//            System.out.println("호출");
            switch (value){
                case 1:
//                    queue.offer(Integer.parseInt(input[1]));
                    int v = scanner.nextInt();
                    queue.offer(v);
                    if(max < queue.size()){
                        max = queue.size();
                        student = v;
                    }
                    else if(max == queue.size()){
//                        list.add(Integer.parseInt(input[1]));
                        student = Math.min(student, v);
                    }
                    break;
                case 2:
                    queue.poll();
            }
//            if(max < queue.size()){
//                max = queue.size();
//                list = new ArrayList<>();
//                for(int j = 0 ; j< queue.size(); j++){
//                    list.add(queue.get(j));
//                }
//            }
//            else if(max == queue.size()){
//                list.add(Integer.parseInt(input[1]));
//            }
//            System.out.println("체크");
        }
//        System.out.println("직전");
//        Collections.reverse(list);
//        System.out.println("중간");
        System.out.println(max + " " + student);
//        System.out.println("마지ㅁ");

    }
}
