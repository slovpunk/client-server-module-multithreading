import java.io.*;

public class Client implements AutoCloseable {
	private BufferedReader inputStream;
	private BufferedWriter outputStream;

	public Client(InputStream is, OutputStream os) {
		this.inputStream = new BufferedReader(new InputStreamReader(is));
		this.outputStream = new BufferedWriter(new OutputStreamWriter(os));
	}

	public String say(String phrase) throws IOException {
		outputStream.write(phrase);
		outputStream.newLine();
		outputStream.flush();
		return inputStream.readLine();
	}

	@Override
	public void close() throws Exception {
		inputStream.close();
		outputStream.close();
	}
}
