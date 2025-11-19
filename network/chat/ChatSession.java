package network.chat;

import network.tcp.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

public class ChatSession implements Runnable {
    private final Socket socket;
    private final DataInputStream input;
    private final DataOutputStream output;
    private static boolean isClosed = false;
    private SessionManager sessionManager;

    public ChatSession(Socket socket, SessionManager sessionManager) throws IOException {
        this.socket = socket;
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
        this.isClosed = false;
        this.sessionManager = sessionManager;
        sessionManager.add(this);
    }

    @Override
    public void run() {
        try{
            while(true){
                String read = input.readUTF();
                if(read == "exit") break;
                sessionManager.snedAll(read);
            }

        } catch (IOException e){
            log(e);
        } finally {
            sessionManager.remove(this);
            close();
        }
    }

    public synchronized void close(){
        if(isClosed) return;
        closeAll(socket,input,output);
        isClosed = true;
        log("연결 종료: " + socket);
    }


    public synchronized void send(String sendTo) throws IOException {
        output.writeUTF(sendTo);
    }
}
