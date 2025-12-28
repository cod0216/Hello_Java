import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        char v = buffer.readLine().charAt(0);

        if(v == 'M') System.out.println("MatKor");
        else if(v == 'W') System.out.println("WiCys");
        else if(v == 'C') System.out.println("CyKor");
        else if(v == 'A') System.out.println("AlKor");
        else if(v == '$') System.out.println("$clear");

    }
}
