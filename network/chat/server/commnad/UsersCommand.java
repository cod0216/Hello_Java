package network.chat.server.commnad;

import network.chat.server.Session;
import network.chat.server.SessionManager;

import java.io.IOException;
import java.util.List;

public class UsersCommand implements Command {
    private final SessionManager sessionManager;

    public UsersCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void excute(String[] args, Session session) throws IOException {
        List<String> names = sessionManager.getAllUsername();
        StringBuilder sb = new StringBuilder();
        sb.append("전체 접속자 : ").append(names.size()).append("\n");
        for (String name : names) {
            sb.append(name).append(" ");
        }
        session.send(sb.toString());
    }
}
