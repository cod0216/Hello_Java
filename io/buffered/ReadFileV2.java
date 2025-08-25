package io.buffered;

import java.io.FileInputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.BUFFER_SIZE;
import static io.buffered.BufferedConst.FILE_NAME;

public class ReadFileV2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[] buffer = new byte[BUFFER_SIZE];
        int filesize = 0;
        int size;
        while ((size = fis.read(buffer)) != -1){
            filesize += size;
        }
        fis.close();
        long endTime = System.currentTimeMillis();

        System.out.println("FILE_NAME = " + FILE_NAME);
        System.out.println("FILE_SIZE = " + filesize/1024/1024 + "MB");
        System.out.println("Time = " + (endTime - startTime)+ "ms");
    }
}
