package io.text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV1 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        // 문자 - byte UTF-8 인코딩
        byte[] bytes = writeString.getBytes(UTF_8);
        System.out.println("write String: " + writeString);
        System.out.println("write bytes: " + Arrays.toString(bytes));

        // 파일에 쓰기
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        fos.write(bytes);
        fos.close();

        // 파일에 읽기
        FileInputStream fis = new FileInputStream(FILE_NAME);
        byte[] readAllBytes = fis.readAllBytes();
        fis.close();

        // byte -> String UTF-8 디코딩
        String readFile = new String(readAllBytes, UTF_8);
        System.out.println("read byte: " + Arrays.toString(readAllBytes));
        System.out.println("read file: " + readFile);


    }
}
