import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestHandler {
    Socket clientSocket;
    public RequestHandler(Socket clientSocket)
    {
        this.clientSocket=clientSocket;
    }

   public void handle() throws IOException {

       BufferedReader reader = new BufferedReader(
               new InputStreamReader(clientSocket.getInputStream())
       );

       String meta = reader.readLine();
       System.out.println("Meta data "+ meta );
       String [] segments =  meta.split(" ");
       String method = segments[0];
       String path =  segments[1];
       String line  ;
       int cnt = 0 ;
        while ((line=reader.readLine())!=null)
        {
            if (cnt>=4)break ;
            cnt ++ ;
            System.out.println(line);

        }
        //response
       ResponseGenerator responseGenerator = new ResponseGenerator();
        String response = responseGenerator.getResponse(path);

        PrintWriter writer = new PrintWriter(
                clientSocket.getOutputStream()
        );
        writer.println(response);
        writer.flush();

        clientSocket.close();
       System.out.println("Client Handled by "+ Thread.currentThread().getName());

   }

}
