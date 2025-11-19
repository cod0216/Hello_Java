package network.chat;

import util.MyLogger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.*;

public class ServerChatting {
    private static final int PORT = 12345;



    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        SessionManager sessionManager = new SessionManager();
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        ShutdownHook shutdownHook = new ShutdownHook(serverSocket);
        Runtime.getRuntime().addShutdownHook(new Thread(shutdownHook, "shutdown"));

        while(true){
            Socket socket = serverSocket.accept();
            log("소켓 연결 : " + socket);

            ChatSession session = new ChatSession(socket, sessionManager);

            Thread thread = new Thread(session);
            thread.start();
        }
    }

    static class ShutdownHook implements Runnable {
        ServerSocket serverSocket;

        public ShutdownHook(ServerSocket serverSocket) {
            this.serverSocket = serverSocket;
        }

        @Override
        public void run(){
            log("shutdownHook 실행");
            try {
                serverSocket.close();

                Thread.sleep(1000);
            }catch (Exception e) {
                e.printStackTrace();
                log(e);
            }
        }
    }
}
