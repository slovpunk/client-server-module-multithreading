import java.net.Socket;
import java.util.Scanner;

public class ClientApplication {
    public static void main(String[] args) throws Exception {
        try (var socket = new Socket("localhost", 8081);
             var client = new Client(socket.getInputStream(), socket.getOutputStream())) {

            while (true) {
                var scanner = new Scanner(System.in);
                System.out.println("result: " + client.say(scanner.nextLine()));

            }
        }
    }
}
