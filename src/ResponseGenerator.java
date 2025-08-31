public class ResponseGenerator {

    public String getResponse(String path ) {
        String body;
        String responseHeader = "HTTP/1.1 200 OK";
        String contentType = "text/html";

        switch (path){
            case "/":
                body="<h1>Welcome to My Java HTTP Server!</h1>" +
                        "<p>Server is Working </p>";
                break;
            default:
                responseHeader = "HTTP/1.1 404 Not Found";
                body = "<h1> 404 - Page Not Found</h1>" +
                        "<p>The page '" + path + "' doesn't exist!</p>" +
                        "<a href='/'>Go back home</a>";
                break;
        }
        return responseHeader + "\n"+
                "Content-Type: "+contentType+"\n"+
                "\n"+ // meta-data separator
                body;
    }
}