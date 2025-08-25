package io.buffered;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.FILE_NAME;
import static io.buffered.BufferedConst.FILE_SIZE;

public class ReadFileV1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        int filesize = 0;
        int data;
        while ((data = fis.read()) != -1){
            filesize++;
        }
        fis.close();
        long endTime = System.currentTimeMillis();

        System.out.println("FILE_NAME = " + FILE_NAME);
        System.out.println("FILE_SIZE = " + filesize/1024/1024 + "MB");
        System.out.println("Time = " + (endTime - startTime)+ "ms");
    }
}
