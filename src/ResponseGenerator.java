public class ResponseGenerator {

    public String getResponse(String path ) {
        String body;
        String responseHeader = "HTTP/1.1 200 OK";
        String contentType = "text/html";

        switch (path){
            case "/":
                body="<h1>Welcome to My Java HTTP Server!</h1>" +
                        "<p>Available routes:</p>" +
                        "<ul>" +
                        "<li><a href='/about'>About</a></li>" +
                        "<li><a href='/random'>Random Number</a></li>" +
                        "<li><a href='/stats'>Server Stats</a></li>" +
                        "</ul>";
                break;
            case "/about":
                body = "<h1> About This Server</h1>" +
                        "<p>This is a custom HTTP server built in Java</p>" +
                        "<p>Features: Multi-threading, routing, and more</p>" ;

                break;
            case "/random":
                int randomNum = (int)(Math.random() * 100);
                body = "<h1>Random Number Generator</h1>" +
                        "<p>Your lucky number: <strong>" + randomNum + "</strong></p>" +
                        "<a href='/random'>Generate Another</a>";
                break;
            case "/stats":
                body = "<h1>Server Statistics</h1>" +
                        "<ul>" +
                        "<li>Active threads: " + Thread.activeCount() + "</li>" +
                        "<li>Available processors: " + Runtime.getRuntime().availableProcessors() + "</li>" +
                        "</ul>";
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

