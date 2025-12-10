import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        int port = 8080;

        try {
            logger.info("Iniciando servidor na porta " + port);

            HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0", port), 0);
            server.createContext("/", new RootHandler());
            server.setExecutor(null);
            server.start();

            logger.info("Servidor rodando em http://localhost:" + port + "/");

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Erro ao iniciar o servidor: ", e);
        }
    }

    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            logger.info("Requisição recebida: " + exchange.getRequestURI());

            String html = """
                    <html>
                      <head><meta charset="UTF-8"><title>Olá Mundo</title></head>
                      <body>
                        <h1>Olá Mundo Web — Java Puro!</h1>
                      </body>
                    </html>
                    """;

            byte[] response = html.getBytes("UTF-8");

            exchange.getResponseHeaders().add("Content-Type", "text/html; charset=utf-8");
            exchange.sendResponseHeaders(200, response.length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response);
                logger.info("Resposta enviada com sucesso.");
            }
        }
    }
}
