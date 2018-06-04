package decoracao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Decoracao {
	public Decoracao() {

	}

	public void metodozinho() {
		try {

			Socket socket = new Socket("192.168.0.5", 9669);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			BufferedReader inTeclado = new BufferedReader(new InputStreamReader(System.in));

			ChatThread bt = new ChatThread(in);

			bt.start();
			String msg = "";

			while ((msg = inTeclado.readLine()) != null) {

				out.println(msg);

				if (msg.equalsIgnoreCase("fim")) {
					break;
				}

			}

			in.close();
			out.close();
			socket.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
