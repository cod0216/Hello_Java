package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class J19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        int startTime = getTime(input[0]);
        int endTime = getTime(input[1]);
        int endStreaming = getTime(input[2]);
        HashSet<String> entryList = new HashSet<>();
        int count = 0;
        String log;
        while((log = buffer.readLine()) != null ){
            input =  log.split(" ");
            if(input.length != 2) continue;
            int time = getTime(input[0]);
//            System.out.println("time = " + time);
            if(time <= startTime){
                entryList.add(input[1]);
//                System.out.println("입장 : " + input[1]);
            }
            else if(time >= endTime && time <= endStreaming && entryList.contains(input[1])){
//                System.out.println("퇴실 : " + input[1]);
                entryList.remove(input[1]);
                count++;
            }
        }
        System.out.println(count);
    }

    private static int getTime(String s) {
        String time[] = s.split(":");

        int hour = Integer.parseInt(time[0]);
        hour = hour * 100;

        int min = Integer.parseInt(time[1]);

        return hour + min;
    }
}
