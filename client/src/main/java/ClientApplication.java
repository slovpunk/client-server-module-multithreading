import java.net.Socket;
import java.util.Scanner;

public class ClientApplication {
    public static void main(String[] args) throws Exception {
            while (true) {
                try (var socket = new Socket("localhost", 8081);
                     var client = new Client(socket.getInputStream(), socket.getOutputStream())) {
                var scanner = new Scanner(System.in);
                client.say(scanner.nextLine());

            }
        }
    }
}
