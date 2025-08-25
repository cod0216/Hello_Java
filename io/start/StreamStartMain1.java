package io.start;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain1 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat",true); // 자바에서 무언가 저장을 하려면 해당 함수가 필요하다. (자바를 기준으로 밖으로 내보난다.)s
        fos.write(65);
        fos.write(66);
        fos.write(67);
        fos.close(); // 외부 자원(지금은 hello.dat)을 쓰고 있으므로 작업이 끝나면 close를 해줘야 된다.

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        System.out.println(fis.read()); // --> 한 바이트 씩 읽는다.
        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read()); // -1은 file의 끝 이르는 뜻
        fis.close();


        /*
            ===========
            int data;
            while((data = fis.read()) != -1) {
                System.out.println(data);
            }
            fis.close();
        */
    }

}
