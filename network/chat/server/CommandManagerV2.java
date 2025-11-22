package network.chat.server;

import util.MyLogger;

import java.io.IOException;
import java.util.List;

public class CommandManagerV2 implements CommandManager{
    private static final String DELIMITER = "\\|";
    private final SessionManager sessionManager;

    public CommandManagerV2(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }


    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        if(totalMessage.startsWith("/join")){
            String username = totalMessage.split(DELIMITER)[1];
            session.setUsername(username);
            sessionManager.sendAll(username + "님이 입장하셨습니다.");
        } else if(totalMessage.startsWith("/message")){
            String message = totalMessage.split(DELIMITER)[1];
            sessionManager.sendAll(session.getUsername() +": " + message);
        } else if(totalMessage.startsWith("/change")){
            String changeName = totalMessage.split(DELIMITER)[1];
            sessionManager.sendAll(session.getUsername() + "님이 " + changeName +"으로 닉네임을 변경하셨습니다.");
            session.setUsername(changeName);
        } else if(totalMessage.startsWith("/users")) {
            List<String> names = sessionManager.getAllUsername();
            StringBuilder sb = new StringBuilder();
            sb.append("전체 접속자 : ").append(names.size()).append("\n");
            for (String name : names) {
                sb.append(name).append(" ");
            }
            session.send(sb.toString());
        } else if(totalMessage.startsWith("/exit")) {
            throw new IOException("exit");
        } else {
            session.send("처리할 수 없는 명령어 입니다. " + totalMessage.split(DELIMITER)[0]);
        }
//        sessionManager.sendAll(totalMessage);
    }


}
