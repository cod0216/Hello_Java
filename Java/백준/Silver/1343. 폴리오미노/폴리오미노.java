import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split("");
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(String t : input){
            char c = t.charAt(0);
            if(c == 'X') cnt++;
            else if(c == '.'){
                while(cnt > 0){
                    if(cnt>=4){
                        for(int i = 0 ; i < 4; i++){
                            sb.append("A");
                        }
                        cnt -= 4;
                    }else if (cnt >=2) {
                        for(int i = 0 ; i < 2; i++){
                            sb.append("B");
                        }
                        cnt -= 2;
                    }else {
                        System.out.println(-1);
                        return;
                    }
                }
                sb.append(".");
            }
        }
        if(cnt >0){
                while(cnt > 0){
                    if(cnt>=4){
                        for(int i = 0 ; i < 4; i++){
                            sb.append("A");
                        }
                        cnt -= 4;
                    }else if (cnt >=2) {
                        for(int i = 0 ; i < 2; i++){
                            sb.append("B");
                        }
                        cnt -= 2;
                    }else {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        
        System.out.println(sb.toString());
    }
}
