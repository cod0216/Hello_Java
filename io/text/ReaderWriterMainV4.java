package io.text;

import java.io.*;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV4 {

    private static final int BUFFER_SIZE = 8912;
    public static void main(String[] args) throws IOException {
        String writeString = "ABC\n가나다";
        System.out.println("====== write String ====== ");
        System.out.println(writeString);

        FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
        BufferedWriter bufferedWriter = new BufferedWriter(fw, BUFFER_SIZE);

        bufferedWriter.write(writeString);
        bufferedWriter.close();

        StringBuilder sb = new StringBuilder();
        FileReader fr = new FileReader(FILE_NAME, UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fr, BUFFER_SIZE);

        String line;
        while((line = bufferedReader.readLine()) != null){
            sb.append(line).append("\n");
        }

        bufferedReader.close();
        System.out.println("====== read String ====== ");
        System.out.println(sb);

    }
}
