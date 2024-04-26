package TIL.review;

import java.util.*;
import java.io.*;

public class J2343 {
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int lecture = Integer.parseInt(input[0]);
        int blueRay = Integer.parseInt(input[1]);

        int[] chapter = new int[lecture];
        input = buffer.readLine().split(" ");

        int longChapter = 0;
        int sumLecture = 0;
        for(int i =0; i< lecture; i++) {
             chapter[i] = Integer.parseInt(input[i]);
             if(longChapter < chapter[i]) longChapter = chapter[i];
             sumLecture +=chapter[i];
        }

        int start = longChapter;
        int end = sumLecture;


        int mid= (end + start)/2;

            while (end >= start) {
                int sum = 0;
                int cd = 0;
                mid = (end + start)/2;
                for(int i =0; i<lecture; i++) {
                    if (sum + chapter[i] > mid) {
                        sum = 0;
                        cd++;
                    }
                    sum += chapter[i];
                }

                if (sum != 0) {
                    cd++;
                }
                if (cd > blueRay) {
                    start = mid + 1;
                } else end = mid - 1;

            }


        System.out.println("start = " + start);
    }
}
