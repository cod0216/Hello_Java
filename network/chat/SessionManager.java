package network.chat;

import java.io.IOException;
import java.util.*;

public class SessionManager {
    private static List<ChatSession> list = new ArrayList<>();


    public static void add(ChatSession session){
        list.add(session);
    }
    public static void remove(ChatSession session){
        list.remove(session);
    }
    public void snedAll(String sendTo) throws IOException {
        for (ChatSession session : list) {
            session.send(sendTo);
        }
    }

    public static void closeAll(){
        for (ChatSession session : list) {
            session.close();
        }
        list.clear();
    }

}
