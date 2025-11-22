package network.chat.server.commnad;

import network.chat.server.Session;

import java.io.IOException;

public interface Command {
    void excute(String[] args, Session session) throws IOException;
}
