package io.file.copy;

import java.io.*;

public class FileCopyMainV1 {
    private static final int FILE_SIZE = 200 * 1024 * 1024; // 200MB

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("temp/copy.dat");
        FileOutputStream fos = new FileOutputStream("temp/copy_new.dat");

        byte[] bytes = fis.readAllBytes();
        fos.write(bytes);

        fis.close();
        fos.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File taken: " + (endTime-startTime) + "ms");
    }
}
