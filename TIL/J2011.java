package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

            public class J2011 {
                static int map[];
                public static void main(String[] args) throws IOException {
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
                    String input = buffer.readLine();
                    int n = input.length();
                    int m = 1000000;
                    map = new int[n+1];

                    map[0] = 1;

                    if(input.charAt(0) == '0'){
                        map[1] = 0;
                        System.out.println(0);
                        return;
                    }
                    else{
                        map[1] = 1;
                    }

                    for(int i = 2 ; i <= n; i++ ){
                        if(input.charAt(i - 1) != '0'){
                            map[i] += map[i - 1];
                            map[i] %= m;
                        }

                        int temp = Integer.parseInt(input.substring(i - 2, i));
                        if (temp >= 10 && temp <= 26) {
                            map[i] += map[i - 2];
                            map[i] %= m;
                        }
                    }

                    System.out.println(map[n]);
                }
            }


