package TIL;
import java.io.*;

public class J1747_0 {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        long key = Long.parseLong(buffer.readLine());
        long result = 0;

        for(long i = key; i<2000000; i++){
            if(!isPrime(i) || !pelinNom(i)) continue;
            result = i;
            break;
        }

        if(key == 1) result = 2;
        System.out.println(result);
    }

    public static boolean isPrime(long a){

        for(long i = 2; i<Math.sqrt(a); i++){
            if(a % i == 0 ) return false;
        }
        return true;
    }
    public static boolean pelinNom(long a){
        String str = String.valueOf(a);
        char[] array = str.toCharArray();
        int len = array.length;

        for(int i =0; i<len/2; i++){
            if (array[i] != array[len-i-1]) return false;
        }
        return true;
    }

}