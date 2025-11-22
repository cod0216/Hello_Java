package network.chat.server.commnad;

import network.chat.server.Session;
import network.chat.server.SessionManager;

import java.io.IOException;

public class ExitCommand implements Command {
    private final SessionManager sessionManager;

    public ExitCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void excute(String[] args, Session session) throws IOException {
        throw new IOException("exit");
    }
}
