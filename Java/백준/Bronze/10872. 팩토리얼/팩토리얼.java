import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        long ans = 1;
        for(int i = 1; i < N; i++){
            ans += ans*i;
        }
        System.out.println(ans);
    }
}
