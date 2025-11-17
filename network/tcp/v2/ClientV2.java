package network.tcp.v2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static util.MyLogger.*;

public class ClientV2 {
    private static final int PORT = 12345;
    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");
        Socket socket = new Socket("localhost", PORT);
        DataInputStream input = new DataInputStream(socket.getInputStream()); // 데이터를 받을 때
        DataOutputStream output = new DataOutputStream(socket.getOutputStream()); // 데이터를 보낼 때
        log("소캣 연결: " + socket);

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("보낼 문자 : ");
            String toSend= scanner.nextLine();

            output.writeUTF(toSend);
            log("client -> server: " + toSend);

            if(toSend.equals("exit")) break;

            String recevied = input.readUTF();
            log("client <- server: " + recevied);


        }






        log("연결 종료: " + socket);
        input.close();
        output.close();
        socket.close();
    }
}
