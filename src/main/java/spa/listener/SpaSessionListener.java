package spa.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SpaSessionListener implements HttpSessionListener {
	
	// 當有新的 session 被創建時
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("有新的 session 被建立, id: " + se.getSession().getId());
	}
	
	// 當有 session 被銷毀時
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("有 session 被銷毀, id: " + se.getSession().getId());
	}

}
