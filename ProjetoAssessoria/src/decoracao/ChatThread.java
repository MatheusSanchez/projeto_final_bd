package decoracao;

import java.io.BufferedReader;
import java.io.IOException;

public class ChatThread extends Thread {
	private BufferedReader in;

	public ChatThread(BufferedReader in) {

		this.in = in;

	}

	public void run() {

		String msg = "";

		try {
			while ((msg = in.readLine()) != null) {

				System.out.println(msg);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
