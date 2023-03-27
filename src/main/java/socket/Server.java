package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws Exception {
		// 建立 Socket Server
		ServerSocket serverSocket = new ServerSocket(5555);
		System.out.println("Socket Server 建立成功 port: " + serverSocket.getLocalPort());
		// 等待 Client 連入
		System.out.println("等待 Client 連入");
		Socket clientSocket = serverSocket.accept(); // 接收到 client 連入資訊
		System.out.println("Client 連入成功");
		// 接收 client 端來的資料
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			out.print(inputLine);
		}
		
		// 關閉 I/O
		out.close();
		in.close();
		
		// 關閉連線
		clientSocket.close();
		serverSocket.close();
	}
	
}