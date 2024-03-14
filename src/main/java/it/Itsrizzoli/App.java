
package it.Itsrizzoli;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class App
{
    static int portNumber = 6666;
    private static ParkingManager pm = new ParkingManager();
    public static void main(String[] args)
    {

        System.out.println("Server started!");



        ServerSocket serverSocket = getServerSocket();
        while (true){
            Socket clientSocket = accept(serverSocket);
            ClientHandler ch = new ClientHandler(clientSocket, pm);
            ch.handle();
        }
    }

    private static Socket accept(ServerSocket serverSocket) {
        Socket clientSocket;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return clientSocket;
    }

    private static ServerSocket getServerSocket() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return serverSocket;
    }
}