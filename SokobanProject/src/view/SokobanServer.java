package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import controller.SokobanController;

public class SokobanServer {
	private ServerSocket serverSocket;
	private View client;
	private boolean stop;
	private SokobanController controller;
	int port;
	
	public SokobanServer(int port) {
		this.port = port;
		this.stop = false;
	}
	
	public void start(){
		try{
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
			try{
				Socket socket = serverSocket.accept();
				new Thread(new Runnable()
				{
					@Override
					public void run() 
					{
						while(!stop)
						{
							try{
								System.out.println("log in");
								client = new CLI(socket.getInputStream(),socket.getOutputStream());
								controller.thereIsClient();
								//socket.getInputStream().close();
								//socket.getOutputStream().close();
								stop();
							}catch(IOException ex){
								System.out.println("CHANNEL ERROR");
							}
						}					
					}
					}).start();
				}catch(SocketTimeoutException ex){
					System.out.println("TIMEOUT ERROR");
				}
			
		}catch(IOException ex){
			System.out.println("SERVER ERROR");
		}
	}
	
	public View getClient(){
		return this.client;
	}
	
	public void setController(SokobanController controller)
	{
		this.controller = controller;
	}
	
	public void stop()
	{
		stop=true;
	}
}
