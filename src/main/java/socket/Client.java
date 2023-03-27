package socket;

import java.net.Socket;

public class Client {
	
	public static void main(String[] args) throws Exception {
		String hostName = "localhost";
		int port = 5555;
		
		// Client 連到 Server 端
		Socket socket = new Socket(hostName, port);
		System.out.println("Client 連到 Server 端成功");
		
		socket.close();
	}
	
}
