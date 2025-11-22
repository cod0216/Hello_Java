package network.chat.server.commnad;

import network.chat.server.Session;
import network.chat.server.SessionManager;

import java.io.IOException;

public class MessageCommand implements Command {
    private final SessionManager sessionManager;

    public MessageCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void excute(String[] args, Session session) throws IOException {
        String message = args[1];
        sessionManager.sendAll(session.getUsername() +": " + message);
    }
}
