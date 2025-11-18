package network.exception.close.normal;

import util.MyLogger;

import java.io.*;
import java.net.Socket;

import static util.MyLogger.log;

public class NormalCloseClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 45678);
        log("소켓 연결 : " + socket);
        InputStream input = socket.getInputStream();
        readByInputStream(input,socket);
        readByBufferedReader(input,socket);
        readByDataInputStrea(input,socket);
        log("연결 종료: " + socket.isClosed());
    }



    private static void readByInputStream(InputStream input, Socket socket) throws IOException {
        int read = input.read();
        log("read = " + read);

        if(read == -1){
            input.close();
            socket.close();
        }

    }
    private static void readByBufferedReader(InputStream input, Socket socket) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
        String readString = buffer.readLine();
        log("readString = " + readString);
        if (readString == null) {
            buffer.close();
            socket.close();
        }
    }
    private static void readByDataInputStrea(InputStream input, Socket socket)throws IOException {
        DataInputStream dis = new DataInputStream(input);

        try{
            dis.readUTF();
        }catch (EOFException e){
            log(e);
        }finally {
            dis.close();
            socket.close();
        }

    }
}
