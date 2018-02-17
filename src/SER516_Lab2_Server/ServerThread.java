package SER516_Lab2_Server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {
    private int localPort;
    private Boolean isStopped;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private InputStream inputStream;
    private OutputStream outputStream;

    ServerThread(int localPort)
    {
        this.localPort = localPort;
        this.isStopped = false;
    }

    @Override
    public void run() {
        try{

            serverSocket = new ServerSocket(localPort);

            while (!isStopped && serverSocket.isBound() && !serverSocket.isClosed())
            {
               clientSocket = serverSocket.accept();
               inputStream = clientSocket.getInputStream();
               outputStream = clientSocket.getOutputStream();
               outputStream.write("Hello From Server".getBytes());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {

        }
    }
}