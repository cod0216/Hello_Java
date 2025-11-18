package network.exception.connect;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SoTimeoutClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 45678);
        InputStream input = socket.getInputStream();
        try{
            socket.setSoTimeout(3000); // 타임 아웃 설정
            int read = input.read();
            System.out.println("read = " + read);
        } catch (Exception e){
            e.printStackTrace();
        }
        socket.close();
    }
}
