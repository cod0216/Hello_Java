package io.file.copy;

import java.io.*;
import java.nio.file.*;

public class FileCopyMainV3 {
    private static final int FILE_SIZE = 200 * 1024 * 1024; // 200MB

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        Path source = Path.of("temp/copy.dat");
        Path target = Path.of("temp/copy_new.dat");
        Files.copy(source,target, StandardCopyOption.REPLACE_EXISTING);

        long endTime = System.currentTimeMillis();
        System.out.println("File taken: " + (endTime-startTime) + "ms");
    }
}
