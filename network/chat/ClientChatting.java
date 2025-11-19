package network.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static util.MyLogger.log;

public class ClientChatting {
    private static final int PORT = 12345;
    public static void main(String[] args) throws IOException {

        try(
                Socket socket = new Socket("localhost" , PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                ){
            log("소켓 연결" + socket);

            Thread read = new Thread(new ReadThread(socket,input), "readThread");
            Thread send = new Thread(new SendThread(socket,output), "sendThread");
            read.start();
            send.start();

        } catch (IOException e){
            log(e);
        }
        System.out.println("연결을 종료합니다.");
    }
    static class ReadThread implements Runnable{
        private Socket socket;
        private DataInputStream input;

        public ReadThread(Socket socket, DataInputStream input) {
            this.socket = socket;
            this.input = input;
        }

        @Override
        public void run() {
            try{
                while(true){
                    System.out.println("받은 문자 : " + input.readUTF());
                }
            }catch (IOException e){
                log(e);
            }
        }
    }
    static class SendThread implements Runnable{
        private Socket socket;
        private DataOutputStream output;

        public SendThread(Socket socket, DataOutputStream output) throws IOException{
            this.socket = socket;
            this.output = output;
        }

        Scanner scanner = new Scanner(System.in);
        @Override
        public void run() {
            try{
                while(true) {
                    System.out.print("보낼 문자 : ");
                    String toSend = scanner.nextLine();
                    output.writeUTF(toSend);
                    if (toSend == "exit") break;
                }
            } catch (IOException e) {
                log(e);
            }
        }
    }
}
