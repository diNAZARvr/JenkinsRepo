import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.Files;

public class LocalServer {
    public static void main(String[] args) throws Exception {
        int port = 8200;

    
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                // Отправляем содержимое index.html как ответ
                File file = new File("index.html");
                byte[] response = Files.readAllBytes(file.toPath());

      
                exchange.sendResponseHeaders(200, response.length);
                OutputStream os = exchange.getResponseBody();
                os.write(response);
                os.close();
            }
        });

        // Запускаем сервер
        server.setExecutor(null); 
        server.start();

        System.out.println("Server started at http://localhost:" + port);
    }
}
