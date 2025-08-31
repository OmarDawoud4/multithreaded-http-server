import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    private static final int port =8080 ;
    public static ExecutorService threadPool = Executors.newFixedThreadPool(8);
    public static void main(String[] args) {
        System.out.println("Server Started... ");

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Listening on port " + port);
            // wait for a client to connect and return a socket
           while (true){
               Socket clientSocket = serverSocket.accept();
                threadPool.submit(()->{
                    RequestHandler handler = new RequestHandler(clientSocket);
                    try {
                        handler.handle();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
           }
        }catch (IOException e){
            System.out.println("Error Starting Server");
        }
    }
}
