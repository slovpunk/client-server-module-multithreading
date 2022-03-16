import java.io.*;
import java.net.Socket;

class ClientHandler implements AutoCloseable {
    private BufferedReader inputStream;
    private BufferedWriter outputStream;

    public ClientHandler(Socket socket) throws Exception {
        this.inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.outputStream = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public void run() throws Exception {
        var command = inputStream.readLine();
        System.out.println(command);
        outputStream.write(command);
        outputStream.flush();
    }

    @Override
    public void close() throws Exception {
        inputStream.close();
        outputStream.close();
    }
}
