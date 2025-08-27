package io.text;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV3 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        System.out.println("write String = " + writeString);

        FileWriter fw = new FileWriter(FILE_NAME);
        fw.write(writeString);
        fw.close();

        FileReader fr = new FileReader(FILE_NAME, UTF_8);

        int ch;
        StringBuilder sb = new StringBuilder();
        while( (ch=fr.read()) != -1){
            sb.append((char)ch);
        }
        fr.close();
        System.out.println("read String = " + sb );



    }
}
