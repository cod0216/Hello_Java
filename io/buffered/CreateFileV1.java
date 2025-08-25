package io.buffered;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.FILE_NAME;
import static io.buffered.BufferedConst.FILE_SIZE;

public class CreateFileV1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        for(int i = 0 ; i < FILE_SIZE; i++){
             fos.write(65);
        }
        fos.close();

        long endTime = System.currentTimeMillis();

        System.out.println("FILE_NAME = " + FILE_NAME);
        System.out.println("FILE_SIZE = " + FILE_SIZE/1024/1024 + "MB");
        System.out.println("Time = " + (endTime - startTime)+ "ms");
    }
}
