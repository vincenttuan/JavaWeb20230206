package websocket;


import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocketTest")
public class WebSocketEndpointTest {

    // 用來存放WebSocket已連接的Socket
    static CopyOnWriteArraySet<Session> sessions;

    @OnMessage
    public void onMessage(String message, Session session) throws IOException,
            InterruptedException, EncodeException {
        System.out.println("session.getId() = " + session.getId() + " message = " + message);
        for (Session s : session.getOpenSessions()) {    //對每個連接的Client傳送訊息
            if (s.isOpen()) {
                s.getAsyncRemote().sendText(message);
            }
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        //紀錄連接到sessions中
        System.out.println("Client 已連線");
        if (sessions == null) {
            sessions = new CopyOnWriteArraySet<Session>();
        }
        sessions.add(session);
        System.out.println("目前連線數 sessions size: " + sessions.size());
        System.out.println("目前的 session.getId() = " + session.getId());
    }

    @OnClose
    public void onClose(Session session) {
        //將連接從sessions中移除
        System.out.println("session.getId() = " + session.getId() + " 連線關閉/離開系統");
        if (sessions == null) {
            sessions = new CopyOnWriteArraySet<Session>();
        }
        sessions.remove(session);

        System.out.println("目前連線數 sessions size: " + sessions.size());
    }
}
