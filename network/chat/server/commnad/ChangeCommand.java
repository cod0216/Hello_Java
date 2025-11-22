package network.chat.server.commnad;

import network.chat.server.Session;
import network.chat.server.SessionManager;

import java.io.IOException;

public class ChangeCommand implements Command {
    private final SessionManager sessionManager;

    public ChangeCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void excute(String[] args, Session session) throws IOException {
        String changeName = args[1];
        sessionManager.sendAll(session.getUsername() + "님이 " + changeName +"으로 닉네임을 변경하셨습니다.");
        session.setUsername(changeName);
    }
}
